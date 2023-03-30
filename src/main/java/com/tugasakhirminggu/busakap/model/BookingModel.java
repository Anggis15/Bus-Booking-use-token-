package com.tugasakhirminggu.busakap.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idKeberangkatan", referencedColumnName = "id")
    private KeberangkatanModel idKeberangkatan;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private PenumpangModel nik;
    private String tanggal;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idJurusan", referencedColumnName = "id")
    private JurusanModel idJurusan;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "noPolisi", referencedColumnName = "noPolisi")
    private BusModel noPolisi;
}
