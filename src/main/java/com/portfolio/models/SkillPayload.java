package com.portfolio.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.multipart.StreamingFileUpload;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class SkillPayload{
    private String name;
    private CompletedFileUpload imageFile;
}
