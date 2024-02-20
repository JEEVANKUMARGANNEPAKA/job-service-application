package com.jeevankumar.jobservice.serviceImpl;

import com.jeevankumar.jobservice.entity.Job;
import com.jeevankumar.jobservice.repository.JobRepository;
import com.jeevankumar.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;


    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
        log.info("saved with with h2 database with job :{}",job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJobById(Long id, Job job) {
     Optional<Job> existingJob= Optional.ofNullable(this.jobRepository.findById(id).orElse(null));
     if (existingJob.isPresent()){
       Job.builder()
                 .description(job.getDescription())
                 .title(job.getTitle())
                 .location(job.getLocation())
                 .minimumSalary(job.getMinimumSalary())
                 .maximumSalary(job.getMaximumSalary())
                 .build();
         jobRepository.save(job);
         return true;
     }else {
     return false;
     }
    }

    @Override
    public boolean deleteJobById(Long id) {
       if(jobRepository.existsById(id)){
           jobRepository.deleteById(id);
           return true;
       }
        return false;
    }
}
