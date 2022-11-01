package com.nashtech.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDto {

    private String creationDate;

    private String lastModifiedDate;

}

