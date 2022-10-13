package com.backapiboats.repository;

import com.backapiboats.model.ReservationModel;
import com.backapiboats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(ReservationModel reservationModel){
        reservationCrudRepository.delete(reservationModel);
        return true;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }
}
