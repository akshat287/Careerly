package com.example.Careerly.job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careerly")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs(){
        return ResponseEntity.ok(jobService.getJobs());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id){
        Job job=jobService.getJobById(id);
        if(job!=null)return new ResponseEntity<>(job, HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable int id){
        boolean bool=jobService.deleteJobById(id);
        if(bool)
            return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id, @RequestBody Job updatedJOB){
        boolean bool=jobService.updateJob(id,updatedJOB);
        if(bool)
            return new ResponseEntity<>("Job Updated!!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
