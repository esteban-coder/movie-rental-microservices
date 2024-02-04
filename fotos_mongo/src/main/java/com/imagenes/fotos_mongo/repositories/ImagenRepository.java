package com.imagenes.fotos_mongo.repositories;

import com.imagenes.fotos_mongo.models.Imagen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenRepository extends MongoRepository<Imagen, String> {
}
