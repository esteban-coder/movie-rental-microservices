package pe.estebancoder.solutions.movierental.membership.service;

import pe.estebancoder.solutions.movierental.membership.model.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> getMemberById(Long memberId);
    boolean isMemberActive(Long memberId);
}
