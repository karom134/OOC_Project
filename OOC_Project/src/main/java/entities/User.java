package entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
@Entity
@Table(name="user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //@Id tell us a primary key and auto increment
    @Column(name="id")
    private Integer id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    private User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
