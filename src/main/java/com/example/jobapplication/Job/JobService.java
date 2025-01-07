package com.example.jobapplication.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
//    update

    Job findById(long id);
    Job deleteById(long id);

    Job updateJob(long id, Job job);
}
