package com.carrental.service;

import com.carrental.model.Reservation;
import com.carrental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    

    @Autowired
    private ReservationRepository reservationRepository;



  //  public List<Reservation> getAllReservation() {
       // return null;
    //}

    @Override
    public List<Reservation> getAllReservation() {
        return null;
    }


}
