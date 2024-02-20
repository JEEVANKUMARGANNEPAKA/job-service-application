package com.jeevankumar.jobservice.service;

import com.jeevankumar.jobservice.entity.Job;

import java.util.List;

public interface JobService {

    void createJob(Job job);
    List<Job> getAllJobs();
    Job getJobById(Long id);
    boolean updateJobById(Long id,Job job);
    boolean deleteJobById(Long id);
}
