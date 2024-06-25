package com.example.assm2.repository;

import com.example.assm2.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepo extends JpaRepository<NSX,Integer> {
}
