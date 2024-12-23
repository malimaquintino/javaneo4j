package com.malimaquintino.javaneo4j.service;

import com.malimaquintino.javaneo4j.dto.CreateLineageDTO;
import com.malimaquintino.javaneo4j.entities.Metadata;
import com.malimaquintino.javaneo4j.entities.MetadataProcess;
import com.malimaquintino.javaneo4j.repository.MetadataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineageService {
    @Autowired
    private MetadataRepository metadataRepository;

    @Transactional
    public void create(CreateLineageDTO lineageDTO) {
        Metadata originMetadata = Metadata.builder().name(lineageDTO.getOriginMetadataName()).build();
        Metadata destinyMetadata = Metadata.builder().name(lineageDTO.getDestinyMetadataName()).build();
        MetadataProcess process = MetadataProcess.builder()
                .name(lineageDTO.getProcessName())
                .target(destinyMetadata)
                .build();

        // Relaciona as tabelas
        metadataRepository.save(originMetadata);
        metadataRepository.save(destinyMetadata);
    }
}
