package com.codeup.spring;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false)
    private String  email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
    

    public User(long id, String username, String email, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(String username, String email, String password, List<Post> posts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
