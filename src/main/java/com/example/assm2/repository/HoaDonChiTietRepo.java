package com.example.assm2.repository;

import com.example.assm2.entity.HoaDon;
import com.example.assm2.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet, Integer> {
    List<HoaDonChiTiet> findAllByHoaDonId(Integer idHoaDon);
}
