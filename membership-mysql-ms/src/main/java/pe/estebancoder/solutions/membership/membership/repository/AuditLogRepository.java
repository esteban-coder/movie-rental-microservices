package pe.estebancoder.solutions.membership.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.membership.membership.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
