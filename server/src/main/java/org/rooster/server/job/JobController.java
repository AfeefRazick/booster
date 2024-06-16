package org.rooster.server.job;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/jobs"))
//@PreAuthorize("hasRole('EMPLOYEE')")
public class JobController {
    private final JobService service;
//    @GetMapping
//    public ResponseEntity<ArrayList<String>> getJob(@PathVariable String jobId) {
//        return ResponseEntity
//                .ok()
//                .body(new ArrayList<>());
//    }

    @GetMapping
    public ResponseEntity<Page<Job>> getJobs(
            @RequestParam(value = "page", defaultValue = "0") int pageNo,
            @RequestParam(value = "limit", defaultValue = "20") int size) {
        return ResponseEntity
                .ok()
                .body(service.findAll(pageNo, size));
    }
}