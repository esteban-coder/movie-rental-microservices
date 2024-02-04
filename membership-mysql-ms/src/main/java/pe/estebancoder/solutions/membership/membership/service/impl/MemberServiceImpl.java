package pe.estebancoder.solutions.membership.membership.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.estebancoder.solutions.membership.membership.model.AuditLog;
import pe.estebancoder.solutions.membership.membership.model.Member;
import pe.estebancoder.solutions.membership.membership.repository.AuditLogRepository;
import pe.estebancoder.solutions.membership.membership.repository.MemberRepository;
import pe.estebancoder.solutions.membership.membership.service.MemberService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AuditLogRepository auditLogRepository;

    public MemberServiceImpl(MemberRepository memberRepository, AuditLogRepository auditLogRepository) {
        this.memberRepository = memberRepository;
        this.auditLogRepository = auditLogRepository;
    }

    /**
     * Changes the status of a member based on the provided DNI (Document National Identification) number.
     *
     * @param dni       The Document National Identification (DNI) number of the member.
     * @param newStatus The new status to set for the member (true for active, false for inactive).
     */
    @Transactional
    public void changeMemberStatus(String dni, boolean newStatus) {
        Optional<Member> optionalMember = memberRepository.findByDni(dni);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            boolean oldStatus = member.isStatus();

            if (oldStatus != newStatus) {
                member.setStatus(newStatus);
                memberRepository.save(member);

                AuditLog auditLog = new AuditLog();
                auditLog.setMember(member);
                auditLog.setOldStatus(oldStatus);
                auditLog.setNewStatus(newStatus);
                auditLog.setChangeDate(LocalDateTime.now());
                auditLogRepository.save(auditLog);
            }
        } else {
            throw new RuntimeException("Socio no encontrado");
        }
    }
}
