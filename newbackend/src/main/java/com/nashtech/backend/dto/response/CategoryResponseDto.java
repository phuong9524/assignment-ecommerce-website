package com.nashtech.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter

public class CategoryResponseDto extends AuditDto{

    private final Integer id;

    private final String categoryName;

    private final String categoryDesc;

    @Builder()
    @JsonCreator
    public CategoryResponseDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String categoryName,
            @JsonProperty("desc") String categoryDesc,
            @JsonProperty("creationDate") String creationDate,
            @JsonProperty("lastModifiedDate") String lastModifiedDate) {
        super(creationDate, lastModifiedDate);
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }
}
