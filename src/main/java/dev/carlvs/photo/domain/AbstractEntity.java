package dev.carlvs.photo.domain;

import java.io.Serializable;
import java.util.UUID;

public interface AbstractEntity extends Serializable {

    UUID geId();
}
