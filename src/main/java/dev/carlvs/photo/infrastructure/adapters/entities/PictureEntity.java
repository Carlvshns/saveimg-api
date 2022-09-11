package dev.carlvs.photo.infrastructure.adapters.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import dev.carlvs.photo.domain.Picture;

@Entity(name = "tb_picture")
public class PictureEntity implements AbstractEntity {

    @Id
    private UUID id;

    @Lob
    private byte[] pictureData;

    public PictureEntity(Picture picture) {
        this.id = picture.geId();
        this.pictureData = picture.getPictureData();
    }

    public PictureEntity(byte[] pictureData) {
        this.pictureData = pictureData;
    }

    public PictureEntity() {
    }

    @Override
    public UUID geId() {
        return this.id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public byte[] getPictureData() {
        return pictureData;
    }
    public void setPictureData(byte[] pictureData) {
        this.pictureData = pictureData;
    }
}
