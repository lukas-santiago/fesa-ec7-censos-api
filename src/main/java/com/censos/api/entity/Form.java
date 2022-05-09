package com.censos.api.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Column(name = "form_id")
    private Long id;
    private String code;
    private String name;
    private String description;
    @Column(name = "expired_at")
    LocalDateTime expiredAt;

    @Column(name = "created_by")
    private String createdBy;

    @OneToMany()
    @JoinColumn(name = "form_field_id")
    private List<FormField> fields = new ArrayList<FormField>();
}