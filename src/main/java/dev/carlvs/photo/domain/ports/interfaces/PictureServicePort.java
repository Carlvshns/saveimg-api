package dev.carlvs.photo.domain.ports.interfaces;


import org.springframework.web.multipart.MultipartFile;

import dev.carlvs.photo.domain.Picture;

public interface PictureServicePort {
    
    public String save(MultipartFile image);

    public void idIsNullable(Picture picture);
    
    public byte[] findById(String pictureId);
}
