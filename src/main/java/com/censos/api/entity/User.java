package com.censos.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotEmpty(message = "Need a name")
    public String name;

    @Column(unique = true)
    @NotEmpty(message = "Need email")
    @Email( message = "Need a valid email")
    public String email;

    @NotEmpty(message = "Need a password")
    public String password;

    // @Embedded
    // public UserMetadata userMetadata;

    // // Metadata
    // @CreatedDate
    // public LocalDateTime created_on;

    // @LastModifiedDate
    // public LocalDateTime updated_on;

    // public Boolean active = true;
}
