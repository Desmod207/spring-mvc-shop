package com.example.springmvcshop.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.springmvcshop.User;

public class RegistrationForm {

  private String username;
  private String password;
  private String fullname;
  private String deliveryAddress;

  public RegistrationForm(String username, String password, String fullname, String deliveryAddress) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.deliveryAddress = deliveryAddress;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }
  
  public User toUser(PasswordEncoder passwordEncoder) {
    
    return new User(
        username, passwordEncoder.encode(password), 
        fullname, deliveryAddress);
  }
  
}
