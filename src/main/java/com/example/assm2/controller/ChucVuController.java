package com.example.assm2.controller;

import com.example.assm2.entity.ChucVu;
import com.example.assm2.entity.MauSac;
import com.example.assm2.repository.ChucVuRepo;
import com.example.assm2.repository.MauSacRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ChucVuController {
    @Autowired
    ChucVuRepo chucVuRepo;
    @GetMapping("hien-thi/chuc-vu")
    public String hienThi(Model model) {
        model.addAttribute("chucVu",new ChucVu());
        model.addAttribute("listChucVu",chucVuRepo.findAll());
        return "/ChucVu/chuc-vu-view";
    }

    @GetMapping("hien-thi/chuc-vu/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        chucVuRepo.deleteById(id);
        return "redirect:/hien-thi/chuc-vu";
    }

    @GetMapping("hien-thi/chuc-vu/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        ChucVu chucVu = chucVuRepo.findById(id).get();
        model.addAttribute("chucVu",chucVu);
        return "/ChucVu/update-chuc-vu";
    }

    @PostMapping("hien-thi/chuc-vu/add")
    public String add(@Valid @ModelAttribute("chucVu") ChucVu chucVu, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            for(FieldError error : bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("listChucVu",chucVuRepo.findAll());
            return "/ChucVu/chuc-vu-view";
        }
        model.addAttribute("chucVu",chucVu);
        chucVuRepo.save(chucVu);
        return "redirect:/hien-thi/chuc-vu";
    }

    @PostMapping("hien-thi/chuc-vu/update")
    public String update(ChucVu chucVu) {
        chucVuRepo.save(chucVu);
        return "redirect:/hien-thi/chuc-vu";
    }


}
