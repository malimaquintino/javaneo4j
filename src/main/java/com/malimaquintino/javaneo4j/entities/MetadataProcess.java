package com.malimaquintino.javaneo4j.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
@Builder
@AllArgsConstructor
public class MetadataProcess {
    @Id
    @GeneratedValue
    private String name;

    @TargetNode
    private final Metadata target;
}
