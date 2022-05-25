package com.censos.api.payload;

import com.censos.api.entity.FormField;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormFieldDTO {
    Long id;
    Long formId;
    Long fieldId;
    String description;
    String data;
    
    public FormFieldDTO(FormField formField) {
        id = formField.getId();
        formId = formField.getForm().getId();
        fieldId = formField.getField().getId();
        description = formField.getDescription();
        data = formField.getData();
    }
}
