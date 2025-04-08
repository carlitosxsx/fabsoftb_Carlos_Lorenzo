package entity;

@Entity
public class Status {
    private int id;
    private String name;

    public Status(int id, String name) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        this.id = id;
        @Column(length = 500, nullable = false)
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}