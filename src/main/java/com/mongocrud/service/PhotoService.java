package com.mongocrud.service;

import com.mongocrud.model.Photo;
import com.mongocrud.repo.PhotoRespository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class PhotoService {

    @Autowired
    private PhotoRespository photoRepo;

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo.setTitle(title);
        photo = photoRepo.save(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
