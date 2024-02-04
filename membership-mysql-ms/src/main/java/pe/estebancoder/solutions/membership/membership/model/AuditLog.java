package pe.estebancoder.solutions.membership.membership.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private boolean oldStatus;
    private boolean newStatus;
    private LocalDateTime changeDate;

    public AuditLog() {
    }

    public AuditLog(Long id, Member member, boolean oldStatus, boolean newStatus, LocalDateTime changeDate) {
        this.id = id;
        this.member = member;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changeDate = changeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(boolean oldStatus) {
        this.oldStatus = oldStatus;
    }

    public boolean isNewStatus() {
        return newStatus;
    }

    public void setNewStatus(boolean newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
