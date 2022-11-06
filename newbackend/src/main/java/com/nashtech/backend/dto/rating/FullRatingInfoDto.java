package com.nashtech.backend.dto.rating;

import com.nashtech.backend.data.entities.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FullRatingInfoDto {

    final Double rate;

    final String comment;

    final User user;

}
