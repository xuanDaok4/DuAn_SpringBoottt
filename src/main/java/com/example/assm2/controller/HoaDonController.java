package com.example.assm2.controller;

import com.example.assm2.entity.HoaDon;
import com.example.assm2.entity.KhachHang;
import com.example.assm2.repository.HoaDonRepo;
import com.example.assm2.repository.KhachHangRepo;
import com.example.assm2.repository.NhanVienRepo;
import jakarta.validation.Valid;
import org.eclipse.jdt.internal.compiler.impl.ShortConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
@Controller
public class HoaDonController {
    @Autowired
    HoaDonRepo hoaDonRepo;
    @Autowired
    NhanVienRepo nhanVienRepo;
    @Autowired
    KhachHangRepo khachHangRepo;

    @GetMapping("hien-thi/hoa-don")
    public String hienThi(Model model) {
        model.addAttribute("hoaDon", new HoaDon());
        model.addAttribute("listHoaDon",hoaDonRepo.findAll());
        model.addAttribute("listNhanVien",nhanVienRepo.findAll());
        model.addAttribute("listKhachHang",khachHangRepo.findAll());
        return "/HoaDon/hoa-don-view";
    }

    @GetMapping("hien-thi/hoa-don/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        hoaDonRepo.deleteById(id);
        return "redirect:/hien-thi/hoa-don";
    }

    @GetMapping("hien-thi/hoa-don/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        HoaDon hoaDon = hoaDonRepo.findById(id).get();
        model.addAttribute("hoaDon",hoaDon);
        model.addAttribute("listNhanVien",nhanVienRepo.findAll());
        model.addAttribute("listKhachHang",khachHangRepo.findAll());
        return "/HoaDon/update-hoa-don";
    }

    @PostMapping("hien-thi/hoa-don/add")
    public String add(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon , BindingResult bindingResult , Model model) {
       if(bindingResult.hasErrors()) {
           for(FieldError error : bindingResult.getFieldErrors()) {
               model.addAttribute(error.getField(),error.getDefaultMessage());
           }
           model.addAttribute("listHoaDon",hoaDonRepo.findAll());
           model.addAttribute("listNhanVien",nhanVienRepo.findAll());
           model.addAttribute("listKhachHang",khachHangRepo.findAll());
         return "/HoaDon/hoa-don-view";
       }
       model.addAttribute("hoaDon",hoaDon);


        LocalDate date = LocalDate.now();
        hoaDon.setNgayTao(date);
        hoaDonRepo.save(hoaDon);
        return "redirect:/hien-thi/hoa-don";
    }

    @PostMapping ("hien-thi/hoa-don/update")
    public String update(HoaDon hoaDon) {
        LocalDate date = LocalDate.now();
        hoaDon.setNgayTao(date);
        hoaDonRepo.save(hoaDon);
        return "redirect:/hien-thi/hoa-don";
    }
}
