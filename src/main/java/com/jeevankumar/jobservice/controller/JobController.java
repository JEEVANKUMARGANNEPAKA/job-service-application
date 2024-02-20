package com.jeevankumar.jobservice.controller;

import com.jeevankumar.jobservice.entity.Job;
import com.jeevankumar.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
             jobService.createJob(job);
       if (job !=null){
           return new ResponseEntity<>("Job object created successfully with id: "+job.getId(),HttpStatus.CREATED);
       }else {
           return new ResponseEntity<>("No object is created",HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobList=jobService.getAllJobs();
        if (jobList !=null){
            return new ResponseEntity<>(jobList,HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
     Job job= jobService.getJobById(id);
     if (job !=null){
         return new ResponseEntity<>(job,HttpStatus.OK);
     }else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job job){
        boolean updateJobObj= jobService.updateJobById(id,job);
        if(updateJobObj){
            return new ResponseEntity<>("updated job successfully "+id,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Id not found for this id : "+id,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean job=jobService.deleteJobById(id);
        if (job)
            return new ResponseEntity<>("Deleted job with id : " + id, HttpStatus.OK);
            return new ResponseEntity<>("there is no id with id:  "+id,HttpStatus.NOT_FOUND);
    }


}
