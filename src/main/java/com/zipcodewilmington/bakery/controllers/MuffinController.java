package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    private MuffinService service;


    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @RequestMapping(path = "/muffins", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/muffins/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/muffins")
    public ResponseEntity<Muffin> create(Muffin muffin) {
        return new ResponseEntity<>(service.create(muffin), HttpStatus.CREATED);
    }

    @PutMapping("/muffins/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, Muffin muffin) {
        return new ResponseEntity<>(service.update(id, muffin), HttpStatus.OK);
    }

    @DeleteMapping("/muffins/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
