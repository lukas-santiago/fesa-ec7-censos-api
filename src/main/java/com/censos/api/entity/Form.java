package com.censos.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    Long id;
    String code;
    String name;
    String description;
    @Column(name = "expired_at")
    LocalDateTime expiredAt;
    @Column(name = "user_id")
    Long userId;
    @OneToMany(mappedBy = "form")
    List<FormField> fields;
}