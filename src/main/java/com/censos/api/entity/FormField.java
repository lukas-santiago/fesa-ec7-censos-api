package com.censos.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "form_field_id")
    Long id;
    @ManyToOne()
    @JoinColumn(name = "form_id")
    Form form;
    @ManyToOne()
    @JoinColumn(name ="field_id")
    Field fieldId;
    String description;
    String data;
}
