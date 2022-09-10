package dev.carlvs.photo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carlvs.photo.domain.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, UUID> {
    
}
