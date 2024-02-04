package pe.estebancoder.solutions.movierental.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.movierental.membership.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
