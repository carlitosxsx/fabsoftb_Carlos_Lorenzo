package entity;

import java.time.LocalDate;

public class Demand {
    private int id;
    private Establishment establishment;
    private Employee responsible;
    private Status status;
    private LocalDate deadline;

    public Demand(int id, Establishment establishment, Employee responsible, Status status, LocalDate deadline) {
        this.id = id;
        this.establishment = establishment;
        this.responsible = responsible;
        this.status = status;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}