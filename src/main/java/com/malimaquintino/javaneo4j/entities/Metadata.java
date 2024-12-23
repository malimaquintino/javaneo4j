package com.malimaquintino.javaneo4j.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@Builder
@AllArgsConstructor
public class Metadata {
    @Id
    private String name;
}
