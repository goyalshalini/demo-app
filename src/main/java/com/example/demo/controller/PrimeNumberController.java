package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.snowdrop.example.service.PrimeNumberInterface;
import org.sl4j.Logger;
import org.sl4j.LoggerFactory;


@RestController
@RequestMapping("/number-test/v1")
public class PrimeNumberController {
    
    @Autowired
    private PrimeNumberInterface primeNumberService;

    private static final Logger Logger = LoggerFactory.getLogger(PrimeNumberController.java);
    
    @RequestMapping(value= "/primeNumber", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getPrimesOnly(@RequestParam int numberToBeSent) {


        try {
        	Logger.info("Number sent for prime calc = " + numberToBeSent );
        	Integer.valueOf(numberToBeSent);
            return new ResponseEntity<>(primeNumberService.numberCalc(numberToBeSent) , HttpStatus.OK);
        } catch(NumberFormatException nbe) {
        	Logger.info("Invalid Input = " + numberToBeSent );
            return new ResponseEntity<>(HttpStatus.NOT_ACCPETABLE);
        } catch(Exception e) {
        	Logger.info("Internal Server Error Occured");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}