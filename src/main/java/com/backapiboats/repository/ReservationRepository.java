package com.backapiboats.repository;

import ch.qos.logback.core.net.server.Client;
import com.backapiboats.model.ClientModel;
import com.backapiboats.model.ClientReport;
import com.backapiboats.model.ReservationModel;
import com.backapiboats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(ReservationModel reservationModel) {
        reservationCrudRepository.delete(reservationModel);
        return true;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

    public List<ReservationModel> getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }

    public List<ClientReport> getTopClients() {
        List<ClientReport> response = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i=0; i< report.size(); i++){
            response.add(new ClientReport((Long)report.get(i)[1], (ClientModel) report.get(i)[0]));
        }
        return response;
    }
}
