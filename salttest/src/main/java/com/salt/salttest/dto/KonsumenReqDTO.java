package com.salt.salttest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KonsumenReqDTO {
    private Long id;
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private Date tglRegistrasi;
    private String status;
}
