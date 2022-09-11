package dev.carlvs.photo.infrastructure.adapters.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carlvs.photo.infrastructure.adapters.entities.PictureEntity;

@Repository
public interface SpringPictureRepository extends JpaRepository<PictureEntity, UUID> {
    
}
