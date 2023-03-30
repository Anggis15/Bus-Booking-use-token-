package com.tugasakhirminggu.busakap.model;

//import jakarta.persistence.*;
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
@Table(name = "penumpang")
public class PenumpangModel {
    @Id
    @Column(length = 16)
    private String nik;
    private String nama;
    private String telepon;
    @Column(unique = true)
    private String username;
    private String password;
}
