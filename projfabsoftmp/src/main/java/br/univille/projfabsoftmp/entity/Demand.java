package entity;

@Entity
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500, nullable = false)
    private String name;
    @ManyToOne
    private Employee responsible;
    @OneToOne
    private Client client;
    @ManyToOne
    private Status status;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    public Demand(int id, Employee responsible, Status status, Date deadline) {
        this.id = id;
        this.responsible = responsible;
        this.status = status;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public Status getStatus() {
        return status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}