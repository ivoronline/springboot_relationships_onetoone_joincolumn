package com.ivoronline.controller;

import com.ivoronline.entity.Address;
import com.ivoronline.entity.Author;
import com.ivoronline.repository.AddressRepository;
import com.ivoronline.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired AuthorRepository  authorRepository;
  @Autowired AddressRepository addressRepository;

  //===========================================================================
  // ADD ADDRESS
  //===========================================================================
  @RequestMapping("AddAddress")
  String addAddress() {

    //CREATE ADDRESS ENTITY
    Address address        = new Address();
            address.city   = "London";
            address.street = "Piccadilly";

    //STORE AUTHOR/ADDRESS ENTITY INTO DB
    addressRepository.save(address);

    //RETURN SOMETHING
    return "ADDRESS.ID = " + address.id;

  }

  //===========================================================================
  // ADD AUTHOR
  //===========================================================================
  @RequestMapping("AddAuthor")
  String addAuthor() {

    //CREATE AUTHOR ENTITY
    Author  author           = new Author();
            author.name      = "John";
            author.age       = 20;
            author.addressId = 1;

    //STORE AUTHOR/ADDRESS ENTITY INTO DB
    authorRepository.save(author);

    //RETURN SOMETHING
    return "Author was stored into DB";

  }

  //===========================================================================
  // GET AUTHOR ADDRESS
  //===========================================================================
  @RequestMapping("GetAuthorAddress")
  String GetAuthorAddress() {

    //GET AUTHOR
    Author author = authorRepository.findById(1).get();

    //GET ADDRESS
    Address address = author.address;

    //RETURN SOMETHING
    return author.name + " lives in " + address.city;
    
  }

}
