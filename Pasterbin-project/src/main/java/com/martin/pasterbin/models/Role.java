//package com.martin.pasterbin.models;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//
//@Entity
//@Table(name="roles")
//@Data
//@NoArgsConstructor
//public class Role implements GrantedAuthority {
//
//    @Id
//    @Column (name = "id")
//    private int id;
//
//    @Column (name = "role")
//    private String role;
//
//    @Override
//    public String getAuthority() {
//        return name();
//    }
//}
