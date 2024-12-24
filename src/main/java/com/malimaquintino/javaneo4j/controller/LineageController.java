package com.malimaquintino.javaneo4j.controller;

import com.malimaquintino.javaneo4j.dto.CreateLineageDTO;
import com.malimaquintino.javaneo4j.service.LineageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/v1/lineage")
@CrossOrigin(origins = "*")
public class LineageController {

    @Autowired
    private LineageService lineageService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDatabase(@RequestBody CreateLineageDTO inputDto) {
        log.info("Create new lineage");
        lineageService.create(inputDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
