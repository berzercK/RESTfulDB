package com.netcracker.BatyrkinAndrew.controller;

import com.netcracker.BatyrkinAndrew.entity.Status;
import com.netcracker.BatyrkinAndrew.entity.Buyer;
import com.netcracker.BatyrkinAndrew.service.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    private final
    IBuyerService iBuyerService;

    @Autowired
    public MyRestController(IBuyerService iBuyerService) {
        this.iBuyerService = iBuyerService;
    }

    @PostMapping(value = "/buyer", consumes = "application/json")
    @Transactional
    public ResponseEntity<Status> addBuyer(@RequestBody Buyer buyer) {
        iBuyerService.addBuyer(buyer);
        return new ResponseEntity<>(new Status("Buyer successfully created"), HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}", produces = "application/json")
    @Transactional
    public ResponseEntity getBuyerById(@PathVariable("id") int idBuyer) {
        Buyer buyer = iBuyerService.findBuyerById(idBuyer);
        if (buyer == null) {
            return new ResponseEntity("Incorrect id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(buyer, HttpStatus.OK);
    }

    @GetMapping(value = "/buyer", produces = "application/json")
    @Transactional
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        return new ResponseEntity<>(iBuyerService.findAllBuyer(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/buyer/{id}")
    @Transactional
    public ResponseEntity<Status> deleteBuyerById(@PathVariable("id") int id) {
        if (iBuyerService.deleteBuyerById(id))
            return new ResponseEntity<>(new Status("Buyer successfully deleted, id = " + id), HttpStatus.OK);
        else return new ResponseEntity<>(new Status("Incorrect id or DB is clear"),HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/buyer")
    @Transactional
    public ResponseEntity<Status> deleteBuyersAll() {
        iBuyerService.deleteAllBuyers();
        return new ResponseEntity<>(new Status("Your DB successfully deleted =D"), HttpStatus.OK);
    }
}
