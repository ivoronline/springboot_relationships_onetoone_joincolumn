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
  public Integer addressId;  //FK to Address
  
  //RELATIONSHIPS
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressId", insertable = false, updatable = false) //referencedColumnName
  public Address address;

}





