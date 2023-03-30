package com.tugasakhirminggu.busakap.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "perusahaan")
public class PerusahaanModel {
    @Id
    @Column(length = 30)
    private String namaPerusahaan;
    private String alamat;
}
