package com.portfolio.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.multipart.CompletedFileUpload;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Table(name="Skill")
public class Skill {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column
    private String name;
    @OneToOne
    private Photo photo;
}


