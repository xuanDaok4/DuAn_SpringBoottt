package com.example.assm2.controller;

import com.example.assm2.entity.KhachHang;
import com.example.assm2.entity.NhanVien;
import com.example.assm2.repository.KhachHangRepo;
import com.example.assm2.repository.NhanVienRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
@Controller
public class NhanVienController {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @GetMapping("hien-thi/nhan-vien")
    public String hienThi(Model model) {
        model.addAttribute("listNhanVien",nhanVienRepo.findAll());
        return "/NhanVien/nv-view";
    }

    @GetMapping("hien-thi/nhan-vien/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        nhanVienRepo.deleteById(id);
        return "redirect:/hien-thi/nhan-vien";
    }

    @GetMapping("hien-thi/nhan-vien/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        NhanVien nhanVien = nhanVienRepo.findById(id).get();
        model.addAttribute("nhanVien",nhanVien);
        return "/NhanVien/update-nhan-vien";
    }

    @PostMapping("hien-thi/nhan-vien/add")
    public String add(NhanVien nhanVien ) {
        LocalDate date = LocalDate.now();
        nhanVien.setNgaySinh(date);
        nhanVienRepo.save(nhanVien);
        return "redirect:/hien-thi/nhan-vien";
    }

    @PostMapping ("hien-thi/nhan-vien/update")
    public String update(NhanVien nhanVien) {
        LocalDate date = LocalDate.now();
        nhanVien.setNgaySinh(date);
        nhanVienRepo.save(nhanVien);
        return "redirect:/hien-thi/nhan-vien";
    }
}
