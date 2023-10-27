package Model;

public class MClient {
    private int ID;
    private String clientName;
    private String address;
    private String email;
    private int age;
    private int money;

    @Override
    public String toString() {
        return "MClient{" +
                "ID=" + ID +
                ", name='" + clientName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
    public MClient() {
    }

    public MClient(int ID, String clientName, String address, String email, int age, int money) {
        super();
        this.ID = ID;
        this.clientName = clientName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.money = money;
    }

    public MClient(int ID, String clientName) {
        super();
        this.ID = ID;
        this.clientName = clientName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
