package dev.carlvs.photo.utils;

import java.util.UUID;

import dev.carlvs.photo.domain.Picture;

public class PictureCreator {
    
    public static Picture pictureCreator() {

        Picture picture = new Picture();
        picture.setId(UUID.fromString("33797e35-1f73-4a85-93b5-0d1f66c094f8"));
        picture.setPictureData(new byte[123]);

        return picture;
    }
}
