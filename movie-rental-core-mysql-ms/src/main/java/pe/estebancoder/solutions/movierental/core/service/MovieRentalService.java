package pe.estebancoder.solutions.movierental.core.service;

import pe.estebancoder.solutions.movierental.core.model.Rental;

public interface MovieRentalService {
    Rental rentMovie(Long memberId, Long movieId);
}
