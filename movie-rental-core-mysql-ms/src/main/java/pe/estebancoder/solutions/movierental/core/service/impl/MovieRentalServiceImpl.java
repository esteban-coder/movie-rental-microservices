package pe.estebancoder.solutions.movierental.core.service.impl;

import java.time.LocalDateTime;
import java.util.Objects;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.movierental.core.feignclient.MemberService;
import pe.estebancoder.solutions.movierental.core.feignclient.response.Member;
import pe.estebancoder.solutions.movierental.core.model.Movie;
import pe.estebancoder.solutions.movierental.core.model.Rental;
import pe.estebancoder.solutions.movierental.core.repository.MovieRepository;
import pe.estebancoder.solutions.movierental.core.repository.RentalRepository;
import pe.estebancoder.solutions.movierental.core.service.MovieRentalService;

@Service
public class MovieRentalServiceImpl implements MovieRentalService {
    private final RentalRepository rentalRepository;
    private final MovieRepository movieRepository;
    private final MemberService memberService;

    public MovieRentalServiceImpl(RentalRepository rentalRepository, MovieRepository movieRepository, MemberService memberService) {
        this.rentalRepository = rentalRepository;
        this.movieRepository = movieRepository;
        this.memberService = memberService;
    }

    /**
     * Alquilar una pelicula a un socio.
     *
     * @param memberId ID del socio que esta alquilando la pelicula
     * @param movieId  ID de la pelicula a ser alquilado
     * @return The rental object created after renting the movie.
     * @throws RuntimeException If the member's membership is not active or valid.
     */
    public Rental rentMovie(Long memberId, Long movieId) {
        ResponseEntity<Member> responseEntity;
        try {
            // Valida si existe el socio
            responseEntity = memberService.getMemberById(memberId);
        }
        catch (FeignException.NotFound e) {
            throw new RuntimeException("Socio no encontrado");
        }

        Member member = responseEntity.getBody();
        if (member==null) {
            throw new RuntimeException("Socio no encontrado");
        }
        if(!member.isActive()){
            throw new RuntimeException("Socio no esta activo");
        }

        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Película no encontrada"));

        // Tambien es valido setear movie de forma manual, pero hay que tener en cuenta 2 cosas:
        // 1. Estar seguro que movieId es un Id valido, sino, habra error de integridad referencial
        // 2. rental devuelto por save tiene en su Movie releaseDate=null y title='another title', pero en la tabla movie no son sus valores
        // Movie movie = new Movie();movie.setId(movieId);movie.setTitle("another title");

        // Crear un nuevo alquiler
        Rental rental = new Rental();
        rental.setMemberId(memberId);
        rental.setMovie(movie);
        rental.setRentalDate(LocalDateTime.now());
        rental.setReturnDate(LocalDateTime.now().plusHours(48)); // Alquilado por 48 horas

        // Save rental in the database
        return rentalRepository.save(rental);
    }

}
