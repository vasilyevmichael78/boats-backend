package com.Michael.boats.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Boat {
  @Id @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

  public Boat(String name, Shipyard shipyard, Model model, int size, int type) {
    this.name = name;
    this.shipyard = shipyard;
    this.model = model;
    this.size = size;
    this.type = type;
  }

  @Column(name = "name")
    private String name;
@ManyToOne
@JoinColumn(name = "shipyard_name")
    private Shipyard shipyard;
@ManyToOne
@JoinColumn(name = "model_model")
    private Model model;
@Column(name= "size")
private int size;
  @Column(name= "type")
  private int type;

  public Boat(String name,  int size, int type) {
    this.name = name;
    this.size = size;
    this.type = type;
  }
}
