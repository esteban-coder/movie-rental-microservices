package pe.estebancoder.solutions.membership.membership.service;

public interface MemberService {
    void changeMemberStatus(String dni, boolean newStatus);
}
