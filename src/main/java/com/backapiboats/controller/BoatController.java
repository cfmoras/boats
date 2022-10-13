package com.backapiboats.controller;

import com.backapiboats.model.BoatModel;
import com.backapiboats.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*")
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<BoatModel> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoat(@PathVariable Integer id) {
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    public BoatModel saveBoat(@RequestBody BoatModel boatModel) {
        return boatService.saveBoat(boatModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBoat(@PathVariable Integer id) {
        return boatService.deleteBoat(id);
    }

    @PutMapping("/update")
    public BoatModel updateBoat(@RequestBody BoatModel boatModel) {
        return boatService.updateBoat(boatModel);
    }
}
