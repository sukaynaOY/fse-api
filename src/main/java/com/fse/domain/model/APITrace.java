package com.fse.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "APITrace")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APITrace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Method", nullable = false, length = 50)
    private String method;

    @Column(name = "Table_Name_y", nullable = false, length = 50)
    private String tableName;

    @Column(name = "dated", nullable = false)
    private LocalDateTime dated;

    @Column(name = "Page_Size")
    private Integer pageSize;

    @Column(name = "Total_Elements")
    private Integer totalElements;
}