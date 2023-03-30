package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.model.KeberangkatanModel;
import com.tugasakhirminggu.busakap.repository.KeberangkatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keberangkatan")
public class KeberangkatanController {
    @Autowired
    KeberangkatanRepository keberangkatanRepository;
    @GetMapping("/")
    private List<KeberangkatanModel> getAllKeberangkatan(){
        return keberangkatanRepository.findAll();
    }
    @PostMapping("/insertkeberangkatan")
    private String insertKeberangkatan(@RequestBody KeberangkatanModel berangkat){
        keberangkatanRepository.save(berangkat);
        return "Keberangkatan Berhasil Di Buat";
    }
}
