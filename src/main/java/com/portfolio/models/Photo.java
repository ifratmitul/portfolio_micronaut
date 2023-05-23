package com.portfolio.models;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
@Entity
@Table(name="Photo")
public class Photo {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String docPublicId;
    @Column
    private String docUrl;
}
