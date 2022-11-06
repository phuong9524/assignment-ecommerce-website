package com.nashtech.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
public class AuditDto {

    final Date creationDate;

    final Date lastModifiedDate;

}

