package com.example.assm2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccoutnSign {
    private Integer id;
    private String user;
    private String pass;
    private String tennv;
    private int MaCV;
    private String tenCV;
}
