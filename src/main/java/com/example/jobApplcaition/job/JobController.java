package com.example.jobApplcaition.job;

import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<@NonNull List<Job>> findAll() {

        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<@NonNull String> createJob(@RequestBody  Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("added successfully....", HttpStatus.OK);
    }
    @GetMapping(" /{id}")
    public ResponseEntity<@NonNull Job> getById(@PathVariable Long id) {
        Job job = jobService.getById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deletedById(id);
        if (deleted) {
            return new ResponseEntity<>("deleted successfully....", HttpStatus.OK);
        }
        return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<@NonNull String> updateJob(@PathVariable Long id, @RequestBody Job updateJob) {

        boolean update = jobService.updateJob(id, updateJob);
        if (update) {
            return new ResponseEntity<>("update successfully.....", HttpStatus.OK);
        }
        return new ResponseEntity<>("id not found", HttpStatus.NOT_FOUND);

    }


}
