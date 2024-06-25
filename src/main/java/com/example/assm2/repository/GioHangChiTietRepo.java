package com.example.assm2.repository;

import com.example.assm2.entity.GioHangChiTiet;
import com.example.assm2.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GioHangChiTietRepo extends JpaRepository<GioHangChiTiet,Integer> {
    List<GioHangChiTiet> findAllByGioHangId(Integer idGioHang);
}
