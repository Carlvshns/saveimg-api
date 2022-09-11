package dev.carlvs.photo.domain.adapters.services;

import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.carlvs.photo.domain.Picture;
import dev.carlvs.photo.domain.ports.interfaces.PictureServicePort;
import dev.carlvs.photo.domain.ports.repositories.PictureRepositoryPort;

public class PictureServiceImpl implements PictureServicePort {
    
    private PictureRepositoryPort pictureRepositoryPort;

    public PictureServiceImpl(PictureRepositoryPort pictureRepositoryPort) {
        this.pictureRepositoryPort = pictureRepositoryPort;
    }

    @Override
    public String save(MultipartFile image) {

        if(image.getContentType().contains("image")) {

            Picture picture = new Picture();

            try {

                picture.setPictureData(image.getBytes());
            
            } catch (IOException e) {

                e.printStackTrace();
            }

                if (picture.geId() == null ) {   picture.setId(UUID.randomUUID());   }

            Picture pictureSaved = this.pictureRepositoryPort.save(picture);

            return "Copy this URL to access your picture: "+ServletUriComponentsBuilder
                                                            .fromCurrentContextPath().toUriString()
                                                            +"/pictures/find?pictureId="
                                                            +pictureSaved.geId().toString();
        } else {

            return "This not a image";
        }
    }

    @Override
    public byte[] findById(String pictureId) {

        byte[] pictureFinded = this.pictureRepositoryPort.findById(pictureId).getPictureData();
        
        return pictureFinded;
    }
}
