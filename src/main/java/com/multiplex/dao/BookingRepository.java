package com.multiplex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
