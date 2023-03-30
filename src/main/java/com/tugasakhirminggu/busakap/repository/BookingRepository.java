package com.tugasakhirminggu.busakap.repository;

import com.tugasakhirminggu.busakap.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
