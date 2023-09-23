package com.martin.pasterbin.models;

//import com.martin.pasterbin.models.enums.Role;
//import com.martin.pasterbin.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
//public class User implements UserDetails {
public class User {

//    public void addPost(Post post){
//        if()
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id")
    private int id;
    @Column (name= "email")
    @Size(min=2, max=20, message = "Поле должно содержать от 2-х до 30-ти символов!")
    private String email;

    @Column (name= "password")
    @Size(min=2, max=20, message = "Поле должно содержать от 3-х до 30-ти символов!")
    private String password;

    @Column (name= "name")
    @Size(min=1, max=20, message = "Поле должно содержать от 1-го до 30-ти символов!")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Post> postList;



    public void addPostToUser(Post post) {
        if (postList == null) {
            postList = new ArrayList<>();
        }
        postList.add(post);
        post.setUser(this);
    }

    public void updatePostUser(int id, String newPost){
        for (Post p:postList) {
            if(p.getId()==id){
                p.setPost(newPost);
                p.setUser(this);
            }
        }
    }



//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;

//    @ElementCollection (targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))  //Что всё это такое???
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles = new HashSet<>();
//
//    //security
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() { // как это работает?
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }

}
