package pe.estebancoder.solutions.movierental.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.estebancoder.solutions.movierental.core.model.Rental;
import pe.estebancoder.solutions.movierental.core.service.MovieRentalService;

import java.util.Map;

@RestController
@RequestMapping("/movie-rental")
public class MovieRentalController {

    private final MovieRentalService movieRentalService;

    public MovieRentalController(MovieRentalService rentalService) {
        this.movieRentalService = rentalService;
    }

    @PostMapping("/rent")
    public ResponseEntity<Rental> rentMovie(@RequestBody Map<String, String> map) {
        Rental rental = movieRentalService.rentMovie(Long.parseLong(map.get("memberId")), Long.parseLong(map.get("movieId")));
        return new ResponseEntity<>(rental, HttpStatus.CREATED);
    }
}
