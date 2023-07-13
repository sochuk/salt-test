package com.salt.salttest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Table(name = "konsumen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Konsumen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat", columnDefinition = "TEXT")
    private String alamat;

    @Column(name = "kota")
    private String kota;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "tgl_registrasi")
    private Date tglRegistrasi;

    @Column(name = "status")
    private String status;

}
