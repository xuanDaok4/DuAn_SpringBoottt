package com.example.assm2.controller;

import com.example.assm2.entity.CuaHang;
import com.example.assm2.entity.MauSac;
import com.example.assm2.repository.ChucVuRepo;
import com.example.assm2.repository.CuaHangRepo;
import com.example.assm2.repository.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CuaHangController {
    @Autowired
    CuaHangRepo cuaHangRepo;

    @GetMapping("hien-thi/cua-hang")
    public String hienThi(Model model) {
        model.addAttribute("listCuaHang",cuaHangRepo.findAll());
        return "/CuaHang/cua-hang-view";
    }

    @GetMapping("hien-thi/cua-hang/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        cuaHangRepo.deleteById(id);
        return "redirect:/hien-thi/cua-hang";
    }

    @GetMapping("hien-thi/cua-hang/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        CuaHang cuaHang = cuaHangRepo.findById(id).get();
        model.addAttribute("cuaHang",cuaHang);
        return "/CuaHang/update-cua-hang";
    }

    @PostMapping("hien-thi/cua-hang/add")
    public String add(CuaHang cuaHang) {
        cuaHangRepo.save(cuaHang);
        return "redirect:/hien-thi/cua-hang";
    }

    @PostMapping ("hien-thi/cua-hang/update")
    public String update(CuaHang cuaHang) {
        cuaHangRepo.save(cuaHang);
        return "redirect:/hien-thi/cua-hang";
    }
}
