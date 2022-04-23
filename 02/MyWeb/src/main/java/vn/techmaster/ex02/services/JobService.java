package vn.techmaster.ex02.services;

import vn.techmaster.ex02.model.Job;


import java.util.List;
import java.util.Set;

public interface JobService {
    Set<Job> findAll();
    Job findById(String id);
    Job addJob(Job job);
    Job updateById(String id, Job job);
    Job deleteById(String id);
    List<Job> sortByLocation();
    Set<Job> getJobBySalary(int salary);
    Set<Job> getJobByKeyword(String keyword);
    Set<Job> getJobByLocationAndKeyWord(String location, String keyword);
}
