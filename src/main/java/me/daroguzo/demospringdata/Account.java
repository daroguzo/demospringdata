package me.daroguzo.demospringdata;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
