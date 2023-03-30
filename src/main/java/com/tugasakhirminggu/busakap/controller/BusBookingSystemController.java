package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.model.PenumpangModel;
import com.tugasakhirminggu.busakap.repository.PenumpangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busbookingsystem")
public class BusBookingSystemController {
    @Autowired
    PenumpangRepository penumpangRepository;

    @GetMapping("/getallpenumpang")
    private List<PenumpangModel> penumpang(){
        return penumpangRepository.findAll();
    }
    @PostMapping("/registrasi")
    private String insertPenumpang(@RequestBody PenumpangModel penumpang){
        penumpangRepository.save(penumpang);
        return "Data Penumpang Berhasil Ditambahkan";
    }
    @GetMapping("/getpenumpang/{nik}")
    private String getPenumpang(@PathVariable("nik") String nik){
        if(penumpangRepository.findByNik(nik) != null){
            return "Penumpang Sudah terdaftar";
        }else{
            return "Penumpang Belum Terdaftar";
        }
    }
}
