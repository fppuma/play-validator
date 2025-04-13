package com.example.play.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("message")
public class MessageController {

  @GetMapping("/{name}")
  public String getMethodName(@PathVariable String name) {
      return String.format("Hello %s", name);
  }
  

}
