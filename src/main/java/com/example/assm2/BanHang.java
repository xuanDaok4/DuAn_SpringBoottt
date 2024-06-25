package com.example.assm2;

import com.example.assm2.entity.ChiTietSP;
import com.example.assm2.entity.GioHang;
import com.example.assm2.entity.GioHangChiTiet;
import com.example.assm2.entity.HoaDon;
import com.example.assm2.entity.HoaDonChiTiet;
import com.example.assm2.entity.KhachHang;
import com.example.assm2.entity.LichSuHoaDon;
import com.example.assm2.entity.NhanVien;
import com.example.assm2.repository.ChiTietSPRepo;
import com.example.assm2.repository.GioHangChiTietRepo;
import com.example.assm2.repository.GioHangRepo;
import com.example.assm2.repository.HoaDonChiTietRepo;
import com.example.assm2.repository.HoaDonRepo;
import com.example.assm2.repository.KhachHangRepo;
import com.example.assm2.repository.LichSuHoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BanHang {

    Integer idHoaDon = 1;
    Integer idGioHang = 1;
    Double tongTien = 0.0;
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    List<GioHangChiTiet> listgioHangChiTiets = new ArrayList<>();
    @Autowired
    ChiTietSPRepo chiTietSPRepo;

    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    GioHangRepo gioHangRepo;

    @Autowired
    GioHangChiTietRepo gioHangChiTietRepo;

    @Autowired
    LichSuHoaDonRepo lichSuHoaDonRepo;

    @GetMapping("hien-thi/ban-hang")
    public String ViewBanHang(Model model) {
        model.addAttribute("listHD", hoaDonRepo.findAll());

        model.addAttribute("listCTSP", chiTietSPRepo.findAll());

        model.addAttribute("tongTien", tongTien);

        listHDCT = hoaDonChiTietRepo.findAllByHoaDonId(idHoaDon);
        model.addAttribute("listHDCT", listHDCT);

        return "/BanHang/ViewBanHang";
    }



//    @GetMapping("/view/gio-hang/{idGH}")
//    public String viewGH(@PathVariable("idGH") Integer idGH,Model model) {
//        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepo.findById(idGH).get();
//        model.addAttribute("gioHangChiTiet",gioHangChiTiet);
//        return "gio-hang";
//    }

    @GetMapping("hien-thi/view/gio-hang")
    public String hienThiGH(Model model) {
       model.addAttribute("listGHCT",gioHangChiTietRepo.findAll());
        model.addAttribute("listGH",gioHangRepo.findAll());
        return "/GioHang/gio-hang";
    }

    @GetMapping("hien-thi/view/hoa-don")
    public String hienThiLichSuHoaDon(Model model) {
        model.addAttribute("listLSHD",lichSuHoaDonRepo.findAll());
        return "/QuanLy/lich-su-hoa-don";
    }

    @GetMapping("hien-thi/ban-hang/delete/soLuong/{idRemove}")
    public String TruSoLuong(@PathVariable("idRemove") Integer idRemove) {
        Integer idHD = 1;
        listHDCT = hoaDonChiTietRepo.findAllByHoaDonId(idHD);
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            if (hoaDonChiTiet.getChiTietSP().getId().equals(idRemove)) {
                hoaDonChiTiet.setSoLuong((hoaDonChiTiet.getSoLuong() - 1));
                hoaDonChiTiet.setTongTien(hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia());
                hoaDonChiTietRepo.save(hoaDonChiTiet);
                break;
            }
        }
        return "redirect:/hien-thi/ban-hang";
    }

    @GetMapping("hien-thi/ban-hang/add/soLuong/{idAdd}")
    public String congSoLuong(@PathVariable("idAdd") Integer idAdd) {
        listHDCT = hoaDonChiTietRepo.findAllByHoaDonId(idHoaDon);
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            if (hoaDonChiTiet.getChiTietSP().getId().equals(idAdd)) {
                hoaDonChiTiet.setSoLuong((hoaDonChiTiet.getSoLuong() + 1));
                hoaDonChiTiet.setTongTien(hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia());
                hoaDonChiTietRepo.save(hoaDonChiTiet);
                break;
            }
        }
        return "redirect:/hien-thi/ban-hang";
    }

    @GetMapping("hien-thi/ban-hang/add/{idCtsp}")
    public String addHoaDon(@PathVariable("idCtsp") Integer idCtsp) {
        ChiTietSP chiTietSP = chiTietSPRepo.findById(idCtsp).get();
        listHDCT = hoaDonChiTietRepo.findAllByHoaDonId(idHoaDon);
        boolean checkCongDon = false;
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            if (hoaDonChiTiet.getChiTietSP().getId().equals(idCtsp)) {
                hoaDonChiTiet.setSoLuong((hoaDonChiTiet.getSoLuong() + 1));
                hoaDonChiTiet.setTongTien(hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia());
                hoaDonChiTietRepo.save(hoaDonChiTiet);
                checkCongDon = true;
                break;
            }
        }
        if (!checkCongDon) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setChiTietSP(chiTietSP);
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(idHoaDon);
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setTongTien(chiTietSP.getGiaBan());
            hoaDonChiTiet.setDonGia(chiTietSP.getGiaBan());
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTietRepo.save(hoaDonChiTiet);
        }
        return "redirect:/hien-thi/ban-hang";
    }

    @GetMapping("hien-thi/detail/hoa-don/{idHD}")
    public String detailHoaDon(@PathVariable("idHD") Integer idHD, Model model) {
        idHoaDon = idHD;

        HoaDon hoaDon = hoaDonRepo.findById(idHD).get();
        model.addAttribute("hoaDon", hoaDon);

        model.addAttribute("listCTSP", chiTietSPRepo.findAll());
        listHDCT = hoaDonChiTietRepo.findAllByHoaDonId(idHD);
        model.addAttribute("listHDCT", listHDCT);
        model.addAttribute("listHD", hoaDonRepo.findAll());
        model.addAttribute("tongTien", tongTien);
        tongTien = 0.0;
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            tongTien += hoaDonChiTiet.getTongTien();
        }
        return "/BanHang/ViewBanHang";
    }

    @GetMapping("/hien-thi/xoaHDCT/{id}")
    public String XoaHDCT(@PathVariable("id") Integer idHD, Model model) {
        hoaDonChiTietRepo.deleteById(idHD);
        return "redirect:/hien-thi/ban-hang";
    }

    @PostMapping("/hien-thi/tao-hao-don")
    public String taoHoaDon(@RequestParam("tongTien") Double tongTien,
                            @RequestParam("idHoaDon") Integer idHoaDon,Model model
    ) {
        HoaDon hoaDon = new HoaDon();
        if (tongTien == 0.0) {
            LocalDate date = LocalDate.now();
            hoaDon.setNgayTao(date);
            hoaDon.setTinhTrang(1);
            hoaDonRepo.save(hoaDon);
            saveHoaDon(hoaDon,tongTien,1);
            return "redirect:/hien-thi/ban-hang";
        } else {
            hoaDon = hoaDonRepo.findById(idHoaDon).get();
//            model.addAttribute("hoaDon", hoaDon);
            hoaDon.setTinhTrang(0);
            hoaDonRepo.save(hoaDon);
            saveHoaDon(hoaDon,tongTien,0);
            return "redirect:/hien-thi/ban-hang";
        }
    }

//    @GetMapping("Seach")
//    public KhachHang Seach(@RequestParam("sdt") String sdt) {
//         return khachHangRepo.findBySdt(sdt);
//    }

    @GetMapping("hien-thi/gio-hang/add/{idCtsp}")
    public String addGioHang(@PathVariable("idCtsp") Integer idCtsp) {
        ChiTietSP chiTietSP = chiTietSPRepo.findById(idCtsp).get();
        listgioHangChiTiets = gioHangChiTietRepo.findAllByGioHangId(idGioHang);
        boolean checkCongDon = false;
        for (GioHangChiTiet gioHangChiTiet : listgioHangChiTiets) {
            if (gioHangChiTiet.getChiTietSP().getId().equals(idCtsp)) {
                gioHangChiTiet.setSoLuong((gioHangChiTiet.getSoLuong() + 1));
                gioHangChiTiet.setTongTien(gioHangChiTiet.getSoLuong() * gioHangChiTiet.getDonGia());
                gioHangChiTietRepo.save(gioHangChiTiet);
                checkCongDon = true;
                break;
            }
        }
        if (!checkCongDon) {
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setChiTietSP(chiTietSP);

            GioHang gioHang=new GioHang();
            gioHang.setId(idGioHang);
            gioHangChiTiet.setGioHang(gioHang);

            gioHangChiTiet.setTongTien(chiTietSP.getGiaBan());
            gioHangChiTiet.setDonGia(chiTietSP.getGiaBan());
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTietRepo.save(gioHangChiTiet);
        }
        return "redirect:/hien-thi/view/gio-hang";
    }

    public void saveHoaDon(HoaDon hoaDon,Double tongTien, Integer trangThai) {
        LichSuHoaDon lichSuHoaDon =new LichSuHoaDon();
        lichSuHoaDon.setHoaDon(hoaDon);
        lichSuHoaDon.setNgayTao(LocalDate.now());
        lichSuHoaDon.setTongTien(tongTien);
        lichSuHoaDon.setTrangThai(trangThai);
        lichSuHoaDonRepo.save(lichSuHoaDon);
    }


    @GetMapping("hien-thi/detail/gioHang/{idHD}")
    public String detailGioHang(@PathVariable("idHD") Integer idHD, Model model) {
        idGioHang = idHD;


        model.addAttribute("listCTSP", chiTietSPRepo.findAll());
        listgioHangChiTiets = gioHangChiTietRepo.findAllByGioHangId(idHD);
        model.addAttribute("listGH",gioHangRepo.findAll());

        model.addAttribute("tongTien", tongTien);
        tongTien = 0.0;
        for (GioHangChiTiet gioHangChiTiet : listgioHangChiTiets) {
            tongTien += gioHangChiTiet.getTongTien();
        }
        return "/BanHang/ViewBanHang";
    }

}
