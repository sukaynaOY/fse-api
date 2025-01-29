package com.fse.domain.model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Immutable // Marks the entity as read-only
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "view_medical") // Maps the entity to the view
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomMedicament;
    private BigInteger prix;
    @Column(name = "created", nullable = false)
    private LocalDateTime created;  // Ensure this field exists
//
}
