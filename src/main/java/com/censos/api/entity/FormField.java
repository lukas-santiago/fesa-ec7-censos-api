package com.censos.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class FormField extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_field_id")
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id", nullable = false)
    Form form;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", referencedColumnName = "field_id", nullable = false)
    Field field;
    String description;
    String data;
}
