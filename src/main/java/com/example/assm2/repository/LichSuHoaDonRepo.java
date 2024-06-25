package com.example.assm2.repository;

import com.example.assm2.entity.LichSuHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuHoaDonRepo extends JpaRepository<LichSuHoaDon,Integer> {
}
