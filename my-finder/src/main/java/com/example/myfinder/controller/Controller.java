package com.example.myfinder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController

public class Controller {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(
            value = "/films/{titre}",
            method = RequestMethod.GET
    )

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getFilms(@PathVariable String titre) {
        System.out.println("Getting Films details for " + titre);

        String response = restTemplate
                .exchange(
                        "http://my-movie//{titre}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {},
                        titre
                )
                .getBody();

        System.out.println("Response Body " + response);

        return (
                "Titre du film -  " + titre + " [ film details " + response + " ]"
        );
    }

    public String fallbackMethod(int employeeId) {
        return "Fallback response:: No employee details available temporarily";
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

