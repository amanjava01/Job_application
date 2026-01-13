package com.example.jobApplcaition.job;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    // private final ArrayList<Job> jobs = new ArrayList<>();

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findAll() {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getById(Long id) {


        return jobRepository.findById(id).orElse(null);
    }

    /* @Override
     public boolean deletedById(Long id) {
         try {
             jobRepository.deleteById(id);
             return true;
         } catch (Exception e) {
             return false;
         }
     }*/
    @Override
    public boolean deletedById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setDescription(updateJob.getDescription());
            job.setLocation(updateJob.getLocation());
            job.setTitle(updateJob.getTitle());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setMinSalary(updateJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}

