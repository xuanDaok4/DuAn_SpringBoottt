package com.example.assm2.controller;

import com.example.assm2.entity.DongSP;
import com.example.assm2.entity.MauSac;
import com.example.assm2.repository.DongSPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class DongSPController {
    @Autowired
    DongSPRepo dongSPRepo;
    @GetMapping("hien-thi/dongsp")
    public String hienThi(Model model) {
        model.addAttribute("listDongSP",dongSPRepo.findAll());
        return "/DongSP/dong-sp";
    }

    @GetMapping("hien-thi/dong-sp/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        dongSPRepo.deleteById(id);
        return "redirect:/hien-thi/dongsp";
    }

    @GetMapping("hien-thi/dong-sp/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        DongSP dongSP = dongSPRepo.findById(id).get();
        model.addAttribute("dongSP",dongSP);
        return "/DongSP/update-dongsp";
    }

    @PostMapping("hien-thi/dong-sp/add")
    public String add(DongSP dongSP) {
        dongSPRepo.save(dongSP);
        return "redirect:/hien-thi/dongsp";
    }

    @PostMapping ("hien-thi/dong-sp/update")
    public String update(DongSP dongSP) {
        dongSPRepo.save(dongSP);
        return "redirect:/hien-thi/dongsp";
    }
}
