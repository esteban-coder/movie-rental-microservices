package com.imagenes.fotos_mongo.services;

import com.imagenes.fotos_mongo.models.Imagen;
import com.imagenes.fotos_mongo.repositories.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    // Método para obtener todas las imágenes de la colección
    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    // Método para obtener una imagen de la colección por su id
    public Imagen findById(String id) {
        return imagenRepository.findById(id).orElse(null);
    }

    // Método para guardar o actualizar una imagen en la colección
    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    // Método para eliminar una imagen de la colección por su id
    public void deleteById(String id) {
        imagenRepository.deleteById(id);
    }
}