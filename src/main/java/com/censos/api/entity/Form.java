package com.censos.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(unique = true)
    public String code;

    @NotEmpty(message = "Need name")
    public String name;

    public String description;

    @Column(updatable = false)
    public LocalDateTime expired_at;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = true, updatable = false)
    public User created_by;

    // Metadata
    // @CreatedDate
    // public LocalDateTime created_on;

    // @LastModifiedDate
    // public LocalDateTime updated_on;
}