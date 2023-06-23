package com.mongocrud.controller;

import com.mongocrud.model.Photo;
import com.mongocrud.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image")MultipartFile image) throws IOException
    {
        String id = photoService.addPhoto(title, image);
        return id;
    }


    @GetMapping("/get/{id}")
    public Photo getPhoto(@PathVariable("id") String id)
    {
        Photo photo = photoService.getPhoto(id);
        return photo;
    }
}
