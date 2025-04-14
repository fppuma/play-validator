package com.example.play.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.play.model.Customer;
import com.example.play.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping("/process")
  public String getMethodName() {
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "John", "READY"));
    customers.add(new Customer(2, "Ana", "READY"));

    this.customerService.process(customers);
      return "ok";
  }

  @PostMapping
  ResponseEntity<String> validateBody(@Valid @RequestBody Customer customer) {
    return ResponseEntity.ok("valid");
  }

}
