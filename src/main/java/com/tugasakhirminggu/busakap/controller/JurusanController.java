package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.model.JurusanModel;
import com.tugasakhirminggu.busakap.repository.JurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    JurusanRepository jurusanRepository;

    @GetMapping("/")
    private List<JurusanModel> getAllJurusan(){
        return jurusanRepository.findAll();
    }

    @PostMapping("/insertjurusan")
    private String insertJurusan(@RequestBody JurusanModel jurusan){
        jurusanRepository.save(jurusan);
        return "Jurusan berhasil di Tambahkan";
    }
}
