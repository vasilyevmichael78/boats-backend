package com.Michael.boats.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipyard {
  @Id
  @Nullable
  @Column(name="name")
  private String name;
  @Column(name = "country")
  private String country;
}
