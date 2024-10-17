package com.test.interview.ServiceRequest.controller;

import com.test.interview.ServiceRequest.dto.SupportRequest;
import com.test.interview.ServiceRequest.entity.Support;
import com.test.interview.ServiceRequest.service.SupportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class SupportController {

    @Autowired
    SupportService supportService;

    @PostMapping("/servicerequest")
    public ResponseEntity createSupport(@RequestBody Support support) {

        try {
            String message = supportService.createNewSupport(support);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/servicerequest/{id}")
    public ResponseEntity fetchSupportBasedOnId(@PathVariable UUID id) {

        Optional<Support> supportResponse = supportService.fetchSupportById(id);

        if (supportResponse.isPresent()) {
            return new ResponseEntity<>(supportResponse.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/servicerequest/all")
    public ResponseEntity fetchAllSupports() {

        List<Support> listOfSupports = supportService.fetchAllSupports();
        if (listOfSupports.isEmpty()) {
            return new ResponseEntity<>("No Supports Found", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listOfSupports, HttpStatus.OK);
        }
    }

    @PutMapping("/servicerequest/update/{id}")
    public ResponseEntity updateSupportBasedOnId(@PathVariable UUID id, @RequestBody SupportRequest supportRequest) {
        try{
            supportService.updateSupportById(id, supportRequest);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/servicerequest/delete/{id}")
    public ResponseEntity deleteSupportBasedOnId(@PathVariable UUID id) {
        int success = supportService.deleteSupportById(id);

        if (success == 1) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

}
