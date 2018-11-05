package com.codeup.spring;

import javax.persistence.*;

@Entity
@Table(name="user_posts")
public class UserPost {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long post_id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public UserPost(long post_id, User user) {
        this.post_id = post_id;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public long getPost_id() {
        return post_id;
    }

    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}