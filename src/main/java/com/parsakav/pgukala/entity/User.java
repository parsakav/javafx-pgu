package com.parsakav.pgukala.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TBL_USER")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public static transient User currentUser=null;
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String phoneNumber;



    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
