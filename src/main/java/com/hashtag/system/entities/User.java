package com.hashtag.system.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sinclairjaza
 * @Date 3/13/22 - 11:33 PM
 * @Project hashtag_system
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    public User(String name){
        this.name = name;
    }
}
