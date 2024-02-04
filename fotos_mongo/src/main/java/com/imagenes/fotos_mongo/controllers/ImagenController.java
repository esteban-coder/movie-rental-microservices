package com.imagenes.fotos_mongo.controllers;

import com.imagenes.fotos_mongo.models.Imagen;
import com.imagenes.fotos_mongo.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    // Método para subir una imagen con su nombre
    @PostMapping
    public ResponseEntity<Imagen> uploadImagen(@RequestParam("file") MultipartFile file, @RequestParam("nombre") String nombre) {
        try {
            Imagen imagen = new Imagen();
            imagen.setNombre(nombre);
            imagen.setContenido(file.getBytes());
            Imagen imagenSaved = imagenService.save(imagen);
            return ResponseEntity.ok(imagenSaved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Método para descargar una imagen por su id
    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadImagen(@PathVariable String id) {
        Imagen imagen = imagenService.findById(id);
        if (imagen == null) {
            return ResponseEntity.notFound().build();
        }
        Resource resource = new ByteArrayResource(imagen.getContenido());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imagen.getNombre() + "\"")
                .body(resource);
    }
}