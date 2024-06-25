package com.example.assm2.controller;

import com.example.assm2.entity.MauSac;
import com.example.assm2.entity.NSX;
import com.example.assm2.repository.MauSacRepo;
import com.example.assm2.repository.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class NSXController {
    @Autowired
    NSXRepo nsxRepo;
    @GetMapping("hien-thi/nsx")
    public String hienThi(Model model) {
        model.addAttribute("listNSX",nsxRepo.findAll());
        return "/NSX/nsx-view";
    }

    @GetMapping("hien-thi/nsx/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        nsxRepo.deleteById(id);
        return "redirect:/hien-thi/nsx";
    }

    @GetMapping("hien-thi/nsx/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        NSX nsx = nsxRepo.findById(id).get();
        model.addAttribute("nsx",nsx);
        return "/NSX/update-nsx";
    }

    @PostMapping("hien-thi/nsx/add")
    public String add(NSX nsx) {
        nsxRepo.save(nsx);
        return "redirect:/hien-thi/nsx";
    }

    @PostMapping ("hien-thi/nsx/update")
    public String update(NSX nsx) {
        nsxRepo.save(nsx);
        return "redirect:/hien-thi/nsx";
    }
}
