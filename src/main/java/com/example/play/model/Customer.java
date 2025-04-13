package com.example.play.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

  private int id;

  @Size(min = 4, max = 15)
  private String name;
  
  private String status;

}
