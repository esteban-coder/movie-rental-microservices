package pe.estebancoder.solutions.membership.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.membership.membership.model.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByDni(String dni);
}
