package com.malimaquintino.javaneo4j.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Node
@Data
@Builder
@AllArgsConstructor
public class MetadataProcess {
    @Id
    private String name;

    @TargetNode
    private final Metadata target;
}
