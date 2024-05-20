public class User {


    String name;
    String surname;
    String email;
    String password;
    int id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';

    }
    public int getId() {
        return id;
    }

    public User(String name, String surname, String email, String password, int id) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.id = id;
    }
}
