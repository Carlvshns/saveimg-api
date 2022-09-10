package dev.carlvs.photo.aplication.adapters.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.carlvs.photo.services.PictureService;

@RestController
@RequestMapping(value = "/pictures")
public class PictureController {

    private PictureService pictureService;
    
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<String> save(@RequestParam(name = "image", required = true) MultipartFile image) {

        return new ResponseEntity<>(pictureService.save(image), HttpStatus.CREATED);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<byte[]> findById(@RequestParam(name = "pictureId", required = true) String pictureId) {
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
                                        "attachment; filename=\"" + "picture" + "\"")
                                        .body(pictureService.findById(pictureId));
    }
}
