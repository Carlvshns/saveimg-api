package dev.carlvs.photo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.carlvs.photo.domain.adapters.services.PictureServiceImpl;
import dev.carlvs.photo.domain.ports.interfaces.PictureServicePort;
import dev.carlvs.photo.domain.ports.repositories.PictureRepositoryPort;

@Configuration
public class BeanConfig {

    @Bean
    PictureServicePort produtoService(PictureRepositoryPort pictureRepositoryPort) {
        return new PictureServiceImpl(pictureRepositoryPort);
    }
}
