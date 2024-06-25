package com.example.assm2.repository;

import com.example.assm2.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    @Query("SELECT k FROM KhachHang k WHERE k.sdt = :sdt")
    KhachHang findBySdt(@Param("sdt") String sdt);
}
