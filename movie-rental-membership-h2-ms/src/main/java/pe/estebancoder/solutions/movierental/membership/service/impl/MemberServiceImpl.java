package pe.estebancoder.solutions.movierental.membership.service.impl;

import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.movierental.membership.model.Member;
import pe.estebancoder.solutions.movierental.membership.repository.MemberRepository;
import pe.estebancoder.solutions.movierental.membership.service.MemberService;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Obtiene un socio por su ID.
     *
     * @param memberId El ID del socio a buscar.
     * @return El socio si se encuentra, o un Optional vacío.
     */
    @Override
    public Optional<Member> getMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Método para verificar si un miembro está activo
    @Override
    public boolean isMemberActive(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        return memberOptional.map(Member::isActive).
                orElseThrow(() -> new RuntimeException("No existe Socio"))  // si no existe el socio, lanza runtimeexception
                //orElse(false) // si no existe el socio, retorna false
                ;
    }

}