package pe.estebancoder.solutions.membership.membership.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.estebancoder.solutions.membership.membership.dto.MemberStatusRequestDTO;
import pe.estebancoder.solutions.membership.membership.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Constructor injection of memberService

    @PostMapping("/change-status")
    public ResponseEntity<String> changeMemberStatus(@RequestBody MemberStatusRequestDTO dto) {
        String dni = dto.getDni();
        boolean newStatus = dto.isNewStatus();

        memberService.changeMemberStatus(dni, newStatus);
        return ResponseEntity.ok("Member status changed successfully: " + newStatus);
    }

}