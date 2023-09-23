package com.martin.pasterbin.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;

    @Column(name="title")
    private String title;
    @Column(name="post")
    private String post;
    @Column(name="popularity")
    private Integer popularity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    public Post(Integer id, String title, String post, int likes, User user) {
//        this.id = id;
//        this.title = title;
//        this.post = post;
//        this.likes = likes;
//        this.user = user;
//    }
}
