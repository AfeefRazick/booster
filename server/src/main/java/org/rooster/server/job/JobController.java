package org.rooster.server.job;


import lombok.RequiredArgsConstructor;
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
@RequestMapping(("/job"))
@PreAuthorize("hasRole('EMPLOYEE')")
public class JobController {
//    @GetMapping
//    public ResponseEntity<ArrayList<String>> getJob(@RequestParam String jobId) {
//        return ResponseEntity
//                .ok()
//                .body(new ArrayList<>());
//    }

    @GetMapping
    public ResponseEntity<ArrayList<String>> getJob() {
        return ResponseEntity
                .ok()
                .body(new ArrayList<>());
    }
}