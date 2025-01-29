package com.fse.payload.request.response;

import com.fse.domain.model.Clinique;
import com.fse.domain.model.Medical;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaginatedResponse {
    private List<Medical> medicalData;  // List of Medical data
    private List<Clinique> cliniqueData; // List of Clinique data List of Clinique data
}