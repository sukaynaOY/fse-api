package com.fse.domain.model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Immutable // Marks the entity as read-only
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "view_clinique") // Maps the entity to the view
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClinique;
    private String address;
    @Column(name = "created", nullable = false)
    private LocalDateTime created;
}
