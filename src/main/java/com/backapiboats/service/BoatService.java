package com.backapiboats.service;

import com.backapiboats.model.BoatModel;
import com.backapiboats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<BoatModel> getAllBoats() {
        return boatRepository.getAllBoats();
    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatRepository.getBoat(id);
    }

    public BoatModel saveBoat(BoatModel boatModel) {
        return boatRepository.saveBoat(boatModel);
    }

    public boolean deleteBoat(Integer id) {
        return boatRepository.deleteBoat(id);
    }

    public BoatModel updateBoat(BoatModel boatModel) {
        return boatRepository.updateBoat(boatModel);

    }
}
