package com.Michael.boats.config;

import com.Michael.boats.models.Boat;
import com.Michael.boats.models.Model;
import com.Michael.boats.models.Shipyard;
import com.Michael.boats.repo.BoatsRepository;
import com.Michael.boats.repo.ModelRepository;
import com.Michael.boats.repo.ShipyardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  @Autowired
  BoatsRepository boatsRepository;
  @Autowired
  ShipyardRepository shipyardRepository;
  @Autowired
  ModelRepository modelRepository;

  @Override
  public void run(String... args) throws Exception {
    dataloader();
  }

  private void dataloader() {
    if (modelRepository.count() == 0) {
      Model model1 = new Model("Karia 31", "2006");
      Model model2 = new Model("Karia 32", "2007");
      Model model3 = new Model("Karia 33", "2008");
      modelRepository.save(model1);
      modelRepository.save(model2);
      modelRepository.save(model3);
    }
    if (shipyardRepository.count() == 0) {

      Shipyard shipyard1 = new Shipyard("Algomar Yachts", "Turkey");
      Shipyard shipyard2 = new Shipyard("Nizza boats", "France");
      shipyardRepository.save(shipyard1);
      shipyardRepository.save(shipyard2);
    }
    if (boatsRepository.count() == 0) {


      Boat boat1 = new Boat("Little Marie",shipyardRepository.getById("Algomar Yachts"),
        modelRepository.getById("Karia 33") ,31, 1);

      boatsRepository.save(boat1);


      System.out.println(boatsRepository.count());
    }
  }
}

