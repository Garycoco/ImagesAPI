package com.gallery.gallery.service;

import com.gallery.gallery.entity.Gallery;
import com.gallery.gallery.repository.GalleryRepository;
import com.gallery.gallery.response.Response;
import com.gallery.gallery.utils.ImageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    @Override
    public List<Gallery> getAllImages() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getImage(Long id) throws ImageNotFoundException {
        return galleryRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image with id " + id + " not found!"));
    }

    @Override
    public Gallery saveImage(Gallery gallery) {
        gallery.setCreatedAt(Date.from(Instant.now()));
        return galleryRepository.save(gallery);
    }

    @Override
    public Response removeAllImages() {
        galleryRepository.deleteAll();
        return new Response("Images successfully deleted!");
    }

    @Override
    public Response removeImage(Long id) throws ImageNotFoundException {
        if (!galleryRepository.existsById(id)) {
            return new Response("Image with id " + id + " does not exist!");
        }
        galleryRepository.delete(galleryRepository.findById(id).get());
        return new Response("Image with id " + id + "successfully deleted!");
    }

    @Override
    public Gallery updateImage(Long id, Gallery gallery) throws ImageNotFoundException {
        return galleryRepository.findById(id).map(gall -> {
            gall.setImageTitle(gallery.getImageTitle());
            gall.setImageUrl(gallery.getImageUrl());
            gall.setCreatedAt(Date.from(Instant.now()));
            return galleryRepository.save(gall);
        }).orElseThrow(() -> new ImageNotFoundException("Image with id " + id +" does not exist!"));
    }
}
