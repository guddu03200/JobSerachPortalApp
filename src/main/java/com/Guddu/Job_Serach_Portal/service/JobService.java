package com.Guddu.Job_Serach_Portal.service;

import com.Guddu.Job_Serach_Portal.model.Job;
import com.Guddu.Job_Serach_Portal.model.JobType;
import com.Guddu.Job_Serach_Portal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    IJobRepo iJobRepo;


    public Iterable<Job> getAllJobs() {
        return iJobRepo.findAll();
    }


    public Optional<Job> getJobById(Long id) {
        return iJobRepo.findById(id);
    }

    public List<Job> getAllSameTypeJobs(JobType type) {
        return iJobRepo.findByJobType(type);
    }

    public List<Job> getAllJobsInASalaryRange(Double salary) {
        return iJobRepo.findBySalaryGreaterThanEqual(salary);
    }

    public List<Job> getJobEithinTheSameCompany(String cName) {
        return iJobRepo.findByCompanyName(cName);
    }

    public String postAJob(Job j) {
        iJobRepo.save(j);
        return "new jon posted";
    }

    public String postJobs(List<Job> jobs) {
        iJobRepo.saveAll(jobs);
        return "Jobs were addeed";
    }

    public String updatedsalaryById(Long id, Double salary) {
        Job j = iJobRepo.findById(id).orElse(null);
        if(j==null){
            return "please enter a correct jon id!!!";
        }
        j.setSalary(salary);
        iJobRepo.save(j);
        return "salary updated";
    }

    public String updateLocationById(Long id, String location) {
        Job j = iJobRepo.findById(id).orElse(null);
        if(j==null){
            return "Please enter a correct jb id";
        }
        j.setLocation(location);
        iJobRepo.save(j);
        return "Location  updated!!";
    }


    public String updateEmailById(Long id, String email) {
        Job j = iJobRepo.findById(id).orElse(null);
        if(j==null){
            return "Please enter a correct job id";
        }
        j.setCompanyEmail(email);
        iJobRepo.save(j);
        return "Email updated";
    }

    public String updateSalaryByType(JobType type) {
        iJobRepo.updateAllSalaryOfSimilarType(type.name());
        return "salary upadte";
    }

    public String removeJobById(Long id) {
        Job j = iJobRepo.findById(id).orElse(null);
        if(j==null){
            return "Id not found";
        }
        iJobRepo.delete(j);
        return "job removed";
    }


    public String removeAllJobOfTheSameCompany(String companyName) {

        iJobRepo.deleteJobsFromTheSameCompany(companyName);
        return "Jobs Deleted from the same company";
    }
}
