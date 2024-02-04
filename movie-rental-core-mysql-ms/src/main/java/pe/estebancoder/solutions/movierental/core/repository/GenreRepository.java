package pe.estebancoder.solutions.movierental.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.movierental.core.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
