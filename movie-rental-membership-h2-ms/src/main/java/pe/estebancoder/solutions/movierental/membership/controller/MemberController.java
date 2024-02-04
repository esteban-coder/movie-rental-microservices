package pe.estebancoder.solutions.movierental.membership.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.estebancoder.solutions.movierental.membership.model.Member;
import pe.estebancoder.solutions.movierental.membership.service.MemberService;

import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Endpoint para obtener un miembro por su ID
    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        return member.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/check-active/{memberId}")
    public ResponseEntity<Boolean> checkMemberActive(@PathVariable Long memberId) {
        boolean isActive = memberService.isMemberActive(memberId);
        return ResponseEntity.ok(isActive);
    }

}
