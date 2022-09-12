package dev.carlvs.photo.domain;

import java.util.UUID;

import dev.carlvs.photo.infrastructure.adapters.entities.PictureEntity;

public class Picture {

    private UUID id;

    private byte[] pictureData;

    public Picture(PictureEntity pictureEntity) {
        this.id = pictureEntity.getId();
        this.pictureData = pictureEntity.getPictureData();
    }

    public Picture(byte[] pictureData) {
        this.pictureData = pictureData;
    }

    public Picture() {
    }

    public UUID getId() {
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
