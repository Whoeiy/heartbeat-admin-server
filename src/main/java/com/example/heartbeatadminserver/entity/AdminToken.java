package com.example.heartbeatadminserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminToken {
    private Integer id;
    private Integer adminId;
    private String token;
}
