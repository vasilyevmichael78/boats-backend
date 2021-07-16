package com.Michael.boats.controllers;

import com.Michael.boats.models.Boat;
import com.Michael.boats.models.BoatDto;
import com.Michael.boats.models.Model;
import com.Michael.boats.models.Shipyard;
import com.Michael.boats.repo.BoatsRepository;
import com.Michael.boats.repo.ModelRepository;
import com.Michael.boats.repo.ShipyardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4333")
@RestController
@RequestMapping("/api")
public class BoatsController {
  @Autowired
  BoatsRepository boatsRepository;
  @Autowired
  ModelRepository modelRepository;
  @Autowired
  ShipyardRepository shipyardRepository;
  @GetMapping("/boats")
  public ResponseEntity<List<Boat>> getAllBoats() {
    try {
      List<Boat> boats =  boatsRepository.findAll();
      return  new ResponseEntity<>(boats, HttpStatus.OK);
    }  catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  }
  @PostMapping("/boats")
  public ResponseEntity<Boat> createBook(@RequestBody BoatDto boat) {
    try {

      Boat newBoat = new Boat(boat.name,  boat.size, boat.type);
      System.out.println("hhhhhh");
      Model newModel = new Model(boat.model, boat.year);
      Shipyard newShipyard = new Shipyard(boat.shipyardName, boat.country);
      modelRepository.save(newModel);
      shipyardRepository.save(newShipyard);
      newBoat.setShipyard(newShipyard);
      newBoat.setModel(newModel);
      Boat _boat = boatsRepository
        .save(newBoat);
      return new ResponseEntity<>(_boat, HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
