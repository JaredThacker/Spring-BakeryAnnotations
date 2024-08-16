package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BakerController {
    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/bakers/{id}")
    public ResponseEntity<Baker> show(@PathVariable("id")Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bakers/")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping(value = "/bakers/{id}/{name}")
    public ResponseEntity<Baker> update(Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping(value = "/bakers/{id}")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
