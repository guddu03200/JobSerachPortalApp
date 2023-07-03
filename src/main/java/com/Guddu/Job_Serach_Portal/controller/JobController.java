package com.Guddu.Job_Serach_Portal.controller;


import com.Guddu.Job_Serach_Portal.model.Job;
import com.Guddu.Job_Serach_Portal.model.JobType;
import com.Guddu.Job_Serach_Portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    //get
    @GetMapping("jobs")
    public  Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    //get job by id
    @GetMapping("job/{id}")
    public Optional<Job> getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    //get all job of same type
    @GetMapping("jobs/type/{type}")
    public List<Job> getAllSameTypeJobs(@PathVariable JobType type){
        return jobService.getAllSameTypeJobs(type);
    }

    //get all jobs above a  certain salary
    @GetMapping("jobs/salary/range/{salary}")
    public List<Job> getAllJobsInASalaryRange(@PathVariable Double salary){
        return jobService.getAllJobsInASalaryRange(salary);
    }

    //get all  jobs within the company
    @GetMapping("jobs/company")
    public List<Job> getAllJobsWithinTheSameCompany(@RequestParam("companyName")String cName){
        return jobService.getJobEithinTheSameCompany(cName);
    }

    //post
    @PostMapping("job")
    public  String postAJob(@RequestBody  Job j){
        return jobService.postAJob(j);
    }

    @PostMapping("jobs")
    public  String postJobs(@RequestBody List<Job> jobs){
        return jobService.postJobs(jobs);
    }

    //put
    //salary updated
    @PutMapping("job/id/{id}/salary/{salary}")
    public String updateSalaryById(@PathVariable Long id, @PathVariable Double salary){
        return jobService.updatedsalaryById(id, salary);
    }



    //update location
    @PutMapping("job/id/{id}/location/{location}")
    public String updateLocationById(@PathVariable Long id, @PathVariable String Location){
        return jobService.updateLocationById(id, Location);
    }

    //update company email
    @PutMapping("job/id/{id}/email/{email}")
    public String updateEmailById(@PathVariable Long id, @PathVariable String email){
        return jobService.updateEmailById(id, email);
    }

    //update all the job Type salaries by 10%
    @PutMapping("jobs/salaryHike/jobType/")
    public String updateSalaryByType(@PathVariable JobType type){
        return jobService.updateSalaryByType(type);
    }

    //Delete job by id
    @DeleteMapping("job/delete/id/{id}")
    public String removeJobById(@PathVariable Long id){
        return jobService.removeJobById(id);
    }

    //Delete all jobs from the same company
    @DeleteMapping("jobs/company/{companyName}")
    public String removeAllJobsOfTheSameCompany(@PathVariable String companyName){
        return jobService.removeAllJobOfTheSameCompany(companyName);
    }





}
