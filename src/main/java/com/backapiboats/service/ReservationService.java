package com.backapiboats.service;

import com.backapiboats.model.ClientReport;
import com.backapiboats.model.ReservationModel;
import com.backapiboats.model.ReservationReport;
import com.backapiboats.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() == null) {
            return reservationRepository.saveReservation(reservationModel);
        } else {
            Optional<ReservationModel>
                    optionalReservationModel = reservationRepository.getReservation(reservationModel.getIdReservation());
            if (optionalReservationModel.isEmpty()) {
                return
                        reservationRepository.saveReservation(reservationModel);
            } else {
                return reservationModel;
            }
        }
    }

    public boolean deleteReservation(Integer id) {
        Boolean aBoolean = getReservation(id).map(reservationModel -> {
            reservationRepository.deleteReservation(reservationModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> optionalReservationModel = reservationRepository.getReservation(reservationModel.getIdReservation());
            if (!optionalReservationModel.isEmpty()) {
                if (reservationModel.getStartDate() != null) {
                    optionalReservationModel.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    optionalReservationModel.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                reservationRepository.saveReservation(optionalReservationModel.get());
                return optionalReservationModel.get();
            } else {
                return reservationModel;
            }
        } else {
            return reservationModel;
        }
    }

    public ReservationReport getReservationStatusReport() {
        List<ReservationModel> completed = reservationRepository.getReservationByStatus("completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }

    public List<ReservationModel> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date aDate = new Date();
        Date bDate = new Date();

        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (aDate.before(bDate)) {
            return reservationRepository.getReservationPeriod(aDate, bDate);
        } else {
            return new ArrayList<>();
        }
    }

    public List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
    }
}
