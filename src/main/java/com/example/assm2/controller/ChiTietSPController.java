package com.example.assm2.controller;

import com.example.assm2.entity.ChiTietSP;
import com.example.assm2.entity.DongSP;
import com.example.assm2.entity.HoaDon;
import com.example.assm2.repository.ChiTietSPRepo;
import com.example.assm2.repository.DongSPRepo;
import com.example.assm2.repository.HoaDonRepo;
import com.example.assm2.repository.KhachHangRepo;
import com.example.assm2.repository.MauSacRepo;
import com.example.assm2.repository.NSXRepo;
import com.example.assm2.repository.NhanVienRepo;
import com.example.assm2.repository.SanPhamRepo;
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

import java.time.LocalDate;
@Controller
public class ChiTietSPController {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Autowired
    NSXRepo nsxRepo;
    @Autowired
    MauSacRepo  mauSacRepo;

    @Autowired
    DongSPRepo dongSPRepo;
    @Autowired
    ChiTietSPRepo chiTietSPRepo;
    @GetMapping("hien-thi/chi-tiet-sp")
    public String hienThi(Model model) {
//        model.addAttribute("hoaDon", new HoaDon());
        model.addAttribute("listSP",sanPhamRepo.findAll());
        model.addAttribute("listNSX",nsxRepo.findAll());
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        model.addAttribute("listDongSP",dongSPRepo.findAll());
        model.addAttribute("listChiTietSP",chiTietSPRepo.findAll());
        return "/ChiTietSP/chi-tiet-sp";
    }

    @GetMapping("hien-thi/chi-tiet-sp/delete/{id}")
    public String Xoa(@PathVariable("id") Integer id) {
        chiTietSPRepo.deleteById(id);
        return "redirect:/hien-thi/chi-tiet-sp";
    }

    @GetMapping("hien-thi/chi-tiet-sp/view-update/{id}")
    public String ViewUpdate(@PathVariable("id") Integer id,Model model) {
        ChiTietSP chiTietSP = chiTietSPRepo.findById(id).get();
        model.addAttribute("listSP",sanPhamRepo.findAll());
        model.addAttribute("listNSX",nsxRepo.findAll());
        model.addAttribute("listMauSac",mauSacRepo.findAll());
        model.addAttribute("listDongSP",dongSPRepo.findAll());
        model.addAttribute("chiTiet",chiTietSP);
        return "/ChiTietSP/update-chi-tiet-sp";
    }

    @PostMapping("hien-thi/chi-tiet-sp/add")
    public String add(ChiTietSP chiTietSP, BindingResult bindingResult , Model model) {
//        if(bindingResult.hasErrors()) {
//            for(FieldError error : bindingResult.getFieldErrors()) {
//                model.addAttribute(error.getField(),error.getDefaultMessage());
//            }
//            model.addAttribute("listHoaDon",hoaDonRepo.findAll());
//            model.addAttribute("listNhanVien",nhanVienRepo.findAll());
//            model.addAttribute("listKhachHang",khachHangRepo.findAll());
//            return "/HoaDon/hoa-don-view";
//        }
//        model.addAttribute("hoaDon",hoaDon);
        chiTietSPRepo.save(chiTietSP);
        return "redirect:/hien-thi/chi-tiet-sp";
    }

    @PostMapping ("hien-thi/chi-tiet-sp/update")
    public String update(ChiTietSP chiTietSP) {
//        LocalDate date = LocalDate.now();
//        hoaDon.setNgayTao(date);
        chiTietSPRepo.save(chiTietSP);
        return "redirect:/hien-thi/chi-tiet-sp";
    }
}
