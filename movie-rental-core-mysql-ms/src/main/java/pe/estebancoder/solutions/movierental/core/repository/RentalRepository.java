package pe.estebancoder.solutions.movierental.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.movierental.core.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
