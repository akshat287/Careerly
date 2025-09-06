package com.example.Careerly.job.impl;

import com.example.Careerly.job.Job;
import com.example.Careerly.job.JobService;
import com.example.Careerly.job.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImplementation implements JobService {

    JobRepo jobRepo;

    public jobServiceImplementation(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public Job getJobById(int id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(int id) {
//        Iterator<Job> it=jobs.iterator();
//        while(it.hasNext()){
//            Job job=it.next();
//            if(job.getId()==id){
//                it.remove();
//                return true;
//            }
//        }
//        return false;

        try{
            jobRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(int id,Job updatedJOB) {
//        Iterator<Job> it=jobs.iterator();
//        while(it.hasNext()){
//            Job job=it.next();
//            if(job.getId()==id){
//                job.setDescription(updatedJOB.getDescription());
//                job.setLocation(updatedJOB.getLocation());
//                job.setTitle(updatedJOB.getTitle());
//                job.setMaxSalarey(updatedJOB.getMaxSalarey());
//                job.setMinSalarey(updatedJOB.getMinSalarey());
//                return true;
//            }
//        }
//        return false;

        Optional<Job> jobOptional=jobRepo.findById(id);
        if(jobOptional.isPresent()){
            Job job=jobOptional.get();
            job.setDescription(updatedJOB.getDescription());
            job.setLocation(updatedJOB.getLocation());
            job.setTitle(updatedJOB.getTitle());
            job.setMaxSalary(updatedJOB.getMaxSalary());
            job.setMinSalary(updatedJOB.getMinSalary());
            jobRepo.save(job);
            return true;
        }
        return false;
    }
}
