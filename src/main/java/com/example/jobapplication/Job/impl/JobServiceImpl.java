package com.example.jobapplication.Job.impl;

import com.example.jobapplication.Job.Job;
import com.example.jobapplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<Job>();
    private long nextId = 1L;

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
    public Job findById(long id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public Job deleteById(long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job i = iterator.next();
            if (i.getId() == id) {
                iterator.remove();
                return i;
            }
        }
        return null;
    }

    @Override
    public Job updateJob(long id, Job job) {

        for (Job i : jobs) {

            if (i.getId() == id) {
                i.setTitle(job.getTitle());
                i.setDescription(job.getDescription());
                i.setMinSalary(job.getMinSalary());
                i.setMaxSalary(job.getMaxSalary());
                i.setLocation(job.getLocation());
                return i;
            }
        }

        return null;
    }


}
