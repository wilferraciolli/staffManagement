package com.wiltech.shifts;


import com.wiltech.libraries.rest.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestRestService {

    @Autowired
    private ShiftService shiftService;

    @GetMapping("")
    public ResponseEntity<ShiftResource> findAll() {

        shiftService.createSchedule();

        return null;
    }

}
