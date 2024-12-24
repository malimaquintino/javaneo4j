package com.malimaquintino.javaneo4j.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@Builder
public class Metadata {
    @Id
    private String name;

    @Relationship(type = "PROCESS", direction = Relationship.Direction.OUTGOING)
    private List<MetadataProcess> relationship = new ArrayList<>();

    public void addRelationship(MetadataProcess relation) {
        if (this.relationship==null){
            this.relationship = new ArrayList<>();
        }
        this.relationship.add(relation);
    }
}
