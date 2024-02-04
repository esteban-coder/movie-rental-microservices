package pe.estebancoder.solutions.movierental.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.movierental.core.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
