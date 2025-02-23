package com.ivoronline.entity;

import javax.persistence.*;

@Entity
public class Author {

  //DATA
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;
  
  //RELATIONSHIPS
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressFk")
  public Address address;

}





