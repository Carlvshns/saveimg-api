package dev.carlvs.photo.infrastructure.adapters.repositories;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.carlvs.photo.infrastructure.adapters.entities.PictureEntity;
import dev.carlvs.photo.utils.PictureCreator;

@DataJpaTest
@DisplayName("Tests for Spring Picture Repository in JPA")
public class SpringPictureRepositoryTest {

    @Autowired
    private SpringPictureRepository springPictureRepository;

    @Test
    @DisplayName("Save returns Picture Entity Object when Sucessful")
    void save_ReturnsPictureEntity_WhenSucessful(){
        
        PictureEntity pictureEntityToSave = new PictureEntity(PictureCreator.pictureCreator());

        PictureEntity pictureEntitySaved = springPictureRepository.save(pictureEntityToSave);

        Assertions.assertNotNull(pictureEntitySaved);
        Assertions.assertEquals(UUID.fromString("33797e35-1f73-4a85-93b5-0d1f66c094f8"), pictureEntitySaved.getId());
        Assertions.assertEquals(123, pictureEntitySaved.getPictureData().length);
    }

    @Test
    @DisplayName("findById returns Picture Entity Optional when Sucessful")
    void findById_ReturnsPictureEntityOptional_WhenSucessful(){
        
        PictureEntity pictureEntityToSave = new PictureEntity(PictureCreator.pictureCreator());

        PictureEntity pictureEntitySaved = springPictureRepository.save(pictureEntityToSave);

        PictureEntity pictureEntityFinded = springPictureRepository.findById(pictureEntityToSave.getId()).get();

        Assertions.assertNotNull(pictureEntityFinded);
        Assertions.assertEquals(pictureEntityFinded.getId(), pictureEntitySaved.getId());
        Assertions.assertEquals(pictureEntityFinded.getPictureData().length, pictureEntitySaved.getPictureData().length);
    }
}
