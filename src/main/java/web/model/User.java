package web.model;

import org.hibernate.ObjectNotFoundException;
import javax.persistence.*;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "email", nullable = false)
    private String email;

    public User() {
    }

    public User(String name, String surname, int age, String city, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() throws ObjectNotFoundException {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname()  {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
