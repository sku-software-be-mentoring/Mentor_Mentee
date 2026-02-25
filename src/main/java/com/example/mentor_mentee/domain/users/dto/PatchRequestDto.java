package com.example.mentor_mentee.domain.users.dto;
import com.example.mentor_mentee.domain.users.enums.Field;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PatchRequestDto {
    @NotNull
    private final Field field;
    @NotBlank
    private final String value;
}
