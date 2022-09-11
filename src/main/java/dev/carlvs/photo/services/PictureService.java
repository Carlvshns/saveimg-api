package dev.carlvs.photo.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.carlvs.photo.infrastructure.adapters.entities.PictureEntity;
import dev.carlvs.photo.infrastructure.adapters.repositories.SpringPictureRepository;

@Service
public class PictureService {
    
    private SpringPictureRepository pictureRepository;

    public PictureService(SpringPictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public String save(MultipartFile image) {

        if(image.getContentType().contains("image")) {

        PictureEntity picture = new PictureEntity();

        try {

            picture.setPictureData(image.getBytes());
            
        } catch (IOException e) {

            e.printStackTrace();
        }

        picture.setId(UUID.randomUUID());

        PictureEntity pictureSaved = this.pictureRepository.save(picture);

        return "Copy this URL to access your picture: "+ServletUriComponentsBuilder
                                                        .fromCurrentContextPath().toUriString()
                                                        +"/pictures/find?pictureId="
                                                        +pictureSaved.geId().toString();
        } else {

            return "This not a image";
        }
    }

    public byte[] findById(String pictureId) {

        byte[] pictureFinded = this.pictureRepository.findById(UUID.fromString(pictureId))
                                                                    .get().getPictureData();
        
        return pictureFinded;
    }
}
