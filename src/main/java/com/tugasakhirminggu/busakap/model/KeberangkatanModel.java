package com.tugasakhirminggu.busakap.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "keberangkatan")
public class KeberangkatanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int harga;
    private String kelas;
    private String tanggal;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idJurusan", referencedColumnName = "id")
    private JurusanModel idJurusan;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "noPolisi", referencedColumnName = "noPolisi")
    private BusModel noPolisi;
}
