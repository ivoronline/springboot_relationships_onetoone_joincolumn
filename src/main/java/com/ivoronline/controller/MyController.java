package com.ivoronline.controller;

import com.ivoronline.entity.Address;
import com.ivoronline.entity.Author;
import com.ivoronline.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired AuthorRepository authorRepository;

  //===========================================================================
  // ADD AUTHOR ADDRESS
  //===========================================================================
  @RequestMapping("AddAuthorAddress")
  String addAuthorAddress() {

    //CREATE ADDRESS
    Address address        = new Address();
            address.city   = "London";
            address.street = "Piccadilly";

    //CREATE AUTHOR
    Author  author         = new Author();
            author.name    = "John";
            author.age     = 20;
            author.address = address;

    //STORE AUTHOR/ADDRESS INTO DB
    authorRepository.save(author);

    //RETURN MESSAGE
    return "Author/Address was stored into DB";

  }
  
  //===========================================================================
  // UPDATE AUTHOR ADDRESS
  //===========================================================================
  @RequestMapping("UpdateAuthorAddress")
  String updateAuthorAddress() {

    //CREATE ADDRESS ENTITY
    Address address        = new Address();
            address.city   = "New York";
            address.street = "Pearl Street";
            
    //UPDATE AUTHOR/ADDRESS
    Author  author         = authorRepository.findById(1).get();
            author.address = address;
    authorRepository.save(author);

    //RETURN MESSAGE
    return "Author/Address was updated in DB";

  }

  //===========================================================================
  // GET AUTHOR ADDRESS
  //===========================================================================
  @RequestMapping("GetAuthorAddress")
  String getAuthorAddress() {

    //GET AUTHOR
    Author author = authorRepository.findById(1).get();

    //RETURN MESSAGE
    return author.name + " lives in " + author.address.city;
    
  }

}
