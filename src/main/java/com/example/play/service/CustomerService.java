package com.example.play.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.play.model.Customer;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

  @Autowired
  private Validator validator;
  public void process(List<Customer> customers) {
    for(Customer customer: customers) {
        Set<ConstraintViolation<Customer>> result = validator.validate(customer);
        if(!result.isEmpty()) {
          log.error("result:{}", result);
        }
    }
  }
}
