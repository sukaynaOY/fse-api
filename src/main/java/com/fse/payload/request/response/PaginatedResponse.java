package com.fse.payload.request.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString

public class PaginatedResponse {
    private List<?> medicalList;
    private List<?> analyseList;
    private List<?> cliniqueList;

    private int medicalPage;
    private int analysePage;
    private int cliniquePage;

    private int medicalTotalPages;
    private int analyseTotalPages;
    private int cliniqueTotalPages;

    private long medicalTotalCount;
    private long analyseTotalCount;
    private long cliniqueTotalCount;


    // Getters and setters
}
