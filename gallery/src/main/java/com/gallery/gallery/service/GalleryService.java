package com.gallery.gallery.service;

import com.gallery.gallery.entity.Gallery;
import com.gallery.gallery.response.Response;

import java.util.List;

public interface GalleryService {
    public List<Gallery> getAllImages();
    public Gallery getImage(Long id);
    public Gallery saveImage(Gallery gallery);
    public Response removeAllImages();
    public Response removeImage(Long id);
    public Gallery updateImage(Long id, Gallery gallery);
}
