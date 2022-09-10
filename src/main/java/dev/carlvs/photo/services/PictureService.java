package dev.carlvs.photo.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.carlvs.photo.domain.Picture;
import dev.carlvs.photo.repositories.PictureRepository;

@Service
public class PictureService {
    
    private PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public String save(MultipartFile image) {

        if(image.getContentType().contains("image")) {

        Picture picture = new Picture();

        try {

            picture.setPictureData(image.getBytes());
            
        } catch (IOException e) {

            e.printStackTrace();
        }

        picture.setId(UUID.randomUUID());

        Picture pictureSaved = this.pictureRepository.save(picture);

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
