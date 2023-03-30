package com.tugasakhirminggu.busakap.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bus")
public class BusModel {
    @Id
    @Column(length = 10)
    private String noPolisi;
    private int kapasitas;
    private String namaSupir;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "namaPerusahaan", referencedColumnName = "namaPerusahaan")
    private PerusahaanModel namaPerusahaan;
}
