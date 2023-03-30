package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.model.PerusahaanModel;
import com.tugasakhirminggu.busakap.repository.PerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perusahaan")
public class PerusahaanController {
    @Autowired
    PerusahaanRepository perusahaanRepository;
    @PostMapping("/insertperusahaan")
    private String insertperusahaan(@RequestBody PerusahaanModel perusahaan){
        perusahaanRepository.save(perusahaan);
        return "Data Sudah Berhasil Ditambahkan";
    }
    @GetMapping("/")
    private List<PerusahaanModel> getAllPerusahaan(){
        return perusahaanRepository.findAll();
    }
}
