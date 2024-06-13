package org.rooster.server.job;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobService {
    private final JobRepository repository;

    public void save(Job job) {
        repository.save(job);
    }

    public List<Job> findAll() {
        return repository.findAll();
    }
}
