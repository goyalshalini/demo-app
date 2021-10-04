package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.sl4j.Logger;
import org.sl4j.LoggerFactory;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberInterface {

	private static final Logger Logger = LoggerFactory.getLogger(PrimeNumberServiceImpl.java);
	
    @Override
    public List<Integer> numberCalc(int numberSent) {
        
        ArrayList<Integer> primeList=new ArrayList();
	    
        //loop through the numbers one by one
        for(int num=2; num < numberSent; num++){
            boolean isPrime = true;

            //check to see if the number is prime
            for(int i=2; i < num/2 ; i++){
            
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            
            // Add the number to List if found prime 
            if(Boolean.TRUE == isPrime)
            	Logger.info("Prime Number added to list : " + num);
            	primeList.add(num);
         }
               
     return primeList;
     }
           
}