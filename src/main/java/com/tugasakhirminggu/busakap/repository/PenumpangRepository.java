package com.tugasakhirminggu.busakap.repository;

import com.tugasakhirminggu.busakap.model.PenumpangModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenumpangRepository extends JpaRepository<PenumpangModel, String> {
    PenumpangModel findByNik(String nik);
    PenumpangModel findByUsername(String username);
}
