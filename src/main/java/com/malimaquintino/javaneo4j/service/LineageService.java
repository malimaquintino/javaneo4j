package com.malimaquintino.javaneo4j.service;

import com.malimaquintino.javaneo4j.dto.CreateLineageDTO;
import com.malimaquintino.javaneo4j.entities.Metadata;
import com.malimaquintino.javaneo4j.entities.MetadataProcess;
import com.malimaquintino.javaneo4j.repository.MetadataRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LineageService {
    @Autowired
    private MetadataRepository metadataRepository;

    public void create(CreateLineageDTO lineageDTO) {
        try {
            Metadata originMetadata =metadataRepository
                    .findById(lineageDTO.getOriginMetadataName())
                    .orElse(Metadata.builder().name(lineageDTO.getOriginMetadataName()).build());
            Metadata destinyMetadata = metadataRepository
                    .findById(lineageDTO.getDestinyMetadataName())
                    .orElse(Metadata.builder().name(lineageDTO.getDestinyMetadataName()).build());


            MetadataProcess process = MetadataProcess.builder()
                    .name(lineageDTO.getProcessName())
                    .target(destinyMetadata)
                    .build();

            originMetadata.addRelationship(process);
            metadataRepository.save(originMetadata);

        } catch (Exception e) {
            log.error("Error on create error:{}", e.getMessage());
            throw e;
        }
    }
}
