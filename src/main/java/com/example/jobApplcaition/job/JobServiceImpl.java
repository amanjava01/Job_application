package com.example.jobApplcaition.job;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final ArrayList<Job> jobs = new ArrayList<>();


    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {

        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }

        return null;
    }

    @Override
    public boolean deletedById(Long id) {

        Iterator<Job> iterator = jobs.iterator();

        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setDescription(updateJob.getDescription());
                job.setLocation(updateJob.getLocation());
                job.setTitle(updateJob.getTitle());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setMinSalary(updateJob.getMinSalary());
            }
            return true;
        }
        return false;
    }
}
