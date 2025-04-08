package entity;

@Entity
public class Client {
    @Id
    @GeneretedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(lenght = 500, nullable = false)
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}