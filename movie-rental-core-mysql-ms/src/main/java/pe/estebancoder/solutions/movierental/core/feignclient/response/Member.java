package pe.estebancoder.solutions.movierental.core.feignclient.response;

public class Member {

    private Long id;
    private String name;
    private boolean active; // Indicator for active membership

    public Member() {
    }

    public Member(Long id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}