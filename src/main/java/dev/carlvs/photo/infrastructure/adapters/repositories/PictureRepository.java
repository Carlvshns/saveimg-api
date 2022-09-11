package dev.carlvs.photo.infrastructure.adapters.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import dev.carlvs.photo.domain.Picture;
import dev.carlvs.photo.domain.ports.repositories.PictureRepositoryPort;
import dev.carlvs.photo.infrastructure.adapters.entities.PictureEntity;

@Component
public class PictureRepository implements PictureRepositoryPort {

    private SpringPictureRepository springPictureRepository;

    public PictureRepository(SpringPictureRepository springPictureRepository) {
        this.springPictureRepository = springPictureRepository;
    }

    @Override
    public Picture save(Picture picture) {

        PictureEntity pictureEntityToSave = new PictureEntity(picture);

        springPictureRepository.save(pictureEntityToSave);

        return new Picture(pictureEntityToSave);
    }

    @Override
    public Picture findById(String pictureId) {
        
        PictureEntity pictureEntityFinded = springPictureRepository.findById(UUID.fromString(pictureId)).get();

        return new Picture(pictureEntityFinded);
    }
    
}
