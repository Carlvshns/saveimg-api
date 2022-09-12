package dev.carlvs.photo.infrastructure.adapters.entities;

import java.io.Serializable;
import java.util.UUID;

public interface AbstractEntity extends Serializable {

    UUID getId();
}
