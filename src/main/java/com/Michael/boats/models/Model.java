package com.Michael.boats.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
  @Id
    @Column(name="model")
  private String model;
  @Column(name = "year")
  private String year;

}
