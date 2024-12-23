package com.malimaquintino.javaneo4j.repository;

import com.malimaquintino.javaneo4j.entities.Metadata;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends Neo4jRepository<Metadata, String> {
}
