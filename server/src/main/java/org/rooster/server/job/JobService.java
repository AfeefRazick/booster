package org.rooster.server.job;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Job> findAll(int pageNo, int size) {
        Page<Job> jobPage = repository.findAll(PageRequest.of(pageNo, size));
        return jobPage;
    }
}
