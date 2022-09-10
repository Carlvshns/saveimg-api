package dev.carlvs.photo.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "tb_picture")
public class Picture implements AbstractEntity {

    @Id
    private UUID id;

    @Lob
    private byte[] pictureData;

    public Picture(byte[] pictureData) {
        this.pictureData = pictureData;
    }

    public Picture() {
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
