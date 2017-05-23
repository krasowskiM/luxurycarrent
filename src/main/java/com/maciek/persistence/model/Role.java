package com.maciek.persistence.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Maciek on 2017-05-10.
 */
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "value")
    private String value;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return value;
    }
}
