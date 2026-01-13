package com.example.jobApplcaition.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getById(Long id);

    boolean deletedById(Long id);

    boolean updateJob(Long id, Job updateJob);


}
