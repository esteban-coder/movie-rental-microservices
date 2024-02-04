package pe.estebancoder.solutions.membership.membership.dto;

public class MemberStatusRequestDTO {
    private String dni;
    private boolean newStatus;

    public MemberStatusRequestDTO() {
    }

    public MemberStatusRequestDTO(String dni, boolean newStatus) {
        this.dni = dni;
        this.newStatus = newStatus;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isNewStatus() {
        return newStatus;
    }

    public void setNewStatus(boolean newStatus) {
        this.newStatus = newStatus;
    }
}
