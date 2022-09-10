package dev.carlvs.photo.domain.ports.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface PictureServicePort {
    
    public String save(MultipartFile image);
    
    public byte[] findById(String pictureId);
}
