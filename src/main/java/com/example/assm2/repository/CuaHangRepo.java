package com.example.assm2.repository;

import com.example.assm2.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepo extends JpaRepository<CuaHang,Integer> {
}
