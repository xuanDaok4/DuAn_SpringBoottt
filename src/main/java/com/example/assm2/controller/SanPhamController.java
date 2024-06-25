package com.example.assm2.controller;

import com.example.assm2.entity.NSX;
import com.example.assm2.entity.SanPham;
import com.example.assm2.repository.NSXRepo;
import com.example.assm2.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @GetMapping("hien-thi/san-pham")
    public String hienThi(Model model) {
        model.addAttribute("listSanPham",sanPhamRepo.findAll());
        return "/SanPham/san-pham-view";
    }

    @GetMapping("hien-thi/san-pham/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        sanPhamRepo.deleteById(id);
        return "redirect:/hien-thi/san-pham";
    }

    @GetMapping("hien-thi/san-pham/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        SanPham sanPham = sanPhamRepo.findById(id).get();
        model.addAttribute("sanPham",sanPham);
        return "/SanPham/update-san-pham";
    }

    @PostMapping("hien-thi/san-pham/add")
    public String add(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
        return "redirect:/hien-thi/san-pham";
    }

    @PostMapping ("hien-thi/san-pham/update")
    public String update(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
        return "redirect:/hien-thi/san-pham";
    }
}
