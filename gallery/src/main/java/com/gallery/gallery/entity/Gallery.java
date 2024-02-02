package com.gallery.gallery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Image url should not be null!")
    private String imageUrl;
    @NotNull(message = "Image title should not be null!")
    private String imageTitle;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    public Gallery() {}

    public Gallery(Long id, String imageTitle, String imageUrl) {
        this.id = id;
        this.imageTitle = imageTitle;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageTitle() {
        return imageTitle;
    }
    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }
    public Date getCreatedAt() { return createdAt;}
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
