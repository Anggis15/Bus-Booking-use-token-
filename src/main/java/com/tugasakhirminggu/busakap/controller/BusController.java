package com.tugasakhirminggu.busakap.controller;

import com.tugasakhirminggu.busakap.model.BusModel;
import com.tugasakhirminggu.busakap.model.PerusahaanModel;
import com.tugasakhirminggu.busakap.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    BusRepository busRepository;
    @GetMapping("/")
    private List<BusModel> buses(){
        return busRepository.findAll();
    }
    @PostMapping("/insertbus")
    private String insertBus(@RequestBody BusModel bus){
        busRepository.save(bus);
        return "Selamat Bus Berhasil Di Tambahkan";
    }
}
