package com.jason.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;

@Slf4j
public class Driver {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("src/main/resources/sample-full.json"), Student.class);

            log.info("--- Basic Info ---");
            log.info("First name : " + student.getFirstName());
            log.info("Last name : " + student.getLastName());

            Address address = student.getAddress();

            log.info("--- Address ---");
            log.info("Street: " + address.getStreet());
            log.info("State: " + address.getState());

            log.info("--- Languages ---");
            Arrays.stream(student.getLanguages()).forEach(l -> log.info(l));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
