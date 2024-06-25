package com.example.assm2.controller;

import com.example.assm2.entity.KhachHang;
import com.example.assm2.entity.MauSac;
import com.example.assm2.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangRepo khachHangRepo;

    @GetMapping("hien-thi/khach-hang")
    public String hienThi(Model model) {
        model.addAttribute("listKhachHang",khachHangRepo.findAll());
        return "/KhachHang/khach-hang-view";
    }

    @GetMapping("hien-thi/khach-hang/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        khachHangRepo.deleteById(id);
        return "redirect:/hien-thi/khach-hang";
    }

    @GetMapping("hien-thi/khach-hang/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        KhachHang khachHang = khachHangRepo.findById(id).get();
        model.addAttribute("khachHang",khachHang);
        return "/KhachHang/update-khach-hang";
    }

    @PostMapping("hien-thi/khach-hang/add")
    public String add(KhachHang khachHang) {
        LocalDate date = LocalDate.now();
     khachHang.setNgaySinh(date);
        khachHangRepo.save(khachHang);
        return "redirect:/hien-thi/khach-hang";
    }

    @PostMapping ("hien-thi/khach-hang/update")
    public String update(KhachHang khachHang) {
        LocalDate date = LocalDate.now();
        khachHang.setNgaySinh(date);
        khachHangRepo.save(khachHang);
        return "redirect:/hien-thi/khach-hang";
    }
}
