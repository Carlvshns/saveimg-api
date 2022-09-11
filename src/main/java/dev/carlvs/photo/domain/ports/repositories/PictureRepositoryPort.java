package dev.carlvs.photo.domain.ports.repositories;

import dev.carlvs.photo.domain.Picture;

public interface PictureRepositoryPort {
    
    public Picture save(Picture picture);
    
    public Picture findById(String pictureId);
}
