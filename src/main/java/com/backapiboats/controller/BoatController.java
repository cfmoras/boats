package com.backapiboats.controller;

import com.backapiboats.model.BoatModel;
import com.backapiboats.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<BoatModel> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoat(@PathVariable("id") Integer id) {
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel saveBoat(@RequestBody BoatModel boatModel) {
        return boatService.saveBoat(boatModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBoat(@PathVariable ("id") Integer id) {
        return boatService.deleteBoat(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel updateBoat(@RequestBody BoatModel boatModel) {
        return boatService.updateBoat(boatModel);
    }
}
