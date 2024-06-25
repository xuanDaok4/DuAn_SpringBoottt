package com.example.assm2.controller;

import com.example.assm2.entity.MauSac;
import com.example.assm2.repository.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MauSacController {
    @Autowired
    MauSacRepo mauSacRepo;
    @GetMapping("hien-thi/mau-sac")
    public String hienThi(Model model) {
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        return "/MauSac/mau-sac-view";
    }

    @GetMapping("hien-thi/mau-sac/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
         mauSacRepo.deleteById(id);
        return "redirect:/hien-thi/mau-sac";
    }

    @GetMapping("hien-thi/mau-sac/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        MauSac mauSac = mauSacRepo.findById(id).get();
        model.addAttribute("mauSac",mauSac);
        return "/MauSac/update-mau-sac";
    }

    @PostMapping ("hien-thi/mau-sac/add")
    public String add(MauSac mauSac) {
        mauSacRepo.save(mauSac);
        return "redirect:/hien-thi/mau-sac";
    }

    @PostMapping ("hien-thi/mau-sac/update")
    public String update(MauSac mauSac) {
        mauSacRepo.save(mauSac);
        return "redirect:/hien-thi/mau-sac";
    }
}
