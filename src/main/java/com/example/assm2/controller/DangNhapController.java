package com.example.assm2.controller;

import com.example.assm2.entity.AccoutnSign;
import com.example.assm2.entity.NhanVien;
import com.example.assm2.repository.AccoutLoginRepo;
import com.example.assm2.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DangNhapController {
    List<NhanVien> list = new ArrayList<>();

    @Autowired
     NhanVienRepo nhanVienRepo;
    @GetMapping("form/dang-nhap")
    public String dangNhap() {
        return "/DangNhap/dang-nhap";
    }

    public boolean check(String use, String pass) {
        for(NhanVien nhanVien : nhanVienRepo.findAll()){
            if(use.equals(nhanVien.getTen()) && pass.equals(nhanVien.getMatKhau())) {
                return true;
            }
        }
        return false;
    }

    private NhanVien findNhanVienByUse(String use) {
        return nhanVienRepo.findAll().stream()
                .filter(nhanVien -> use.equals(nhanVien.getTen()))
                .findFirst()
                .orElse(null);
    }

//    private NhanVien findNhanVienByUse(String use) {
//        return  NhanVien(use);
//    }

    @PostMapping("hien-thi-dang-nhap")
    public String Login(@RequestParam("use") String use,
                        @RequestParam("pass") String pass,
                        Model model
                        ) {
       boolean login =  check(use, pass);
            if (login) {
                System.out.println("Dang nhap thanh cong");
                NhanVien nhanVien = findNhanVienByUse(use);
                 model.addAttribute("nhanVien", nhanVien);
                 return "redirect:/hien-thi/ban-hang";
            } else {
                System.out.println("Dang nhap that bai");
                model.addAttribute("error", "Unable to find user details.");
                return "/DangNhap/dang-nhap";
            }
        }
}
