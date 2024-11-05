package com.ijse.springintro.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name; 

   @OneToMany(mappedBy = "category")
   private List<Product> products;   //return type will be Array
}
