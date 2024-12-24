package com.malimaquintino.javaneo4j.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateLineageDTO {
    private String originMetadataName;
    private String destinyMetadataName;
    private String processName;
}
