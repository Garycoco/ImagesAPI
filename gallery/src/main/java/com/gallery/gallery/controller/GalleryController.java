package com.gallery.gallery.controller;

import com.gallery.gallery.entity.Gallery;
import com.gallery.gallery.response.Response;
import com.gallery.gallery.service.GalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("images")
public class GalleryController {
    @Autowired
    private GalleryServiceImpl service;
    @GetMapping
    public ResponseEntity<List<Gallery>> getAllImages() {
        return ResponseEntity.ok(service.getAllImages());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getImageById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getImage(id));
    }
    @PostMapping
    public ResponseEntity<Gallery> saveImage(@RequestBody Gallery gallery) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveImage(gallery));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> removeImageById(@PathVariable Long id) {
        return ResponseEntity.ok(new Response("Image with id " + id +" successfully removed!"));
    }
}
