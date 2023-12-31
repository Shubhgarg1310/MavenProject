package com.programming.springBootConcepts.SpringMVCBootJavaProject.controllers;

import com.programming.springBootConcepts.SpringMVCBootJavaProject.beans.Product;
import com.programming.springBootConcepts.SpringMVCBootJavaProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/search")
    public String searchPage(@RequestParam("search") String search, Model model){
        System.out.println("In Search Controller");
        System.out.println("Searching for " + search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products",products);
        return "search";
    }
}
