package com.censos.api.payload;

import com.censos.api.entity.Auditable;
import com.censos.api.entity.FormExecution;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FormExecutionDTO {
    private Long id;
    private String answer;
    private Long formId;
    private Long formFieldId;

    public FormExecutionDTO(FormExecution formExecution) {
        id = formExecution.getId();
        answer = formExecution.getAnswer();
        formId = formExecution.getFormId();
        formFieldId = formExecution.getFormFieldId();
    }
}