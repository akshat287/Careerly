package com.example.Careerly.job;

import java.util.List;

public interface JobService {
    List<Job> getJobs();
    void createJob(Job job);

    Job getJobById(int id);

    boolean deleteJobById(int id);

    boolean updateJob(int id, Job job);
}
