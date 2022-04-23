package vn.techmaster.ex02.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vn.techmaster.ex02.model.Job;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    protected Map<String, Job> map = new HashMap<>();

    @Override
    public Set<Job> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Job findById(String id) {
        Job job = map.get(id);
        if (job == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Job not found");
        }

        return job;
    }

    @Override
    public Job addJob(Job job) {
            String jobId = UUID.randomUUID().toString();
            job.setId(jobId);
            map.put(jobId, job);
        return job;
    }

    @Override
    public Job updateById(String id, Job jobRequest) {
        Job existingJob = map.get(id);
        if (existingJob == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Job not found");
        }
        existingJob.setTitle(jobRequest.getTitle());
        existingJob.setDescription(jobRequest.getDescription());
        existingJob.setLocation(jobRequest.getLocation());
        existingJob.setMinSalary(jobRequest.getMinSalary());
        existingJob.setMaxSalary(jobRequest.getMaxSalary());

        return existingJob;
    }

    @Override
    public Job deleteById(String id) {
        Job deletedJob = map.get(id);
        if (deletedJob == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"Job not found");
        }
        map.remove(id);
        return deletedJob;
    }

    @Override
    public List<Job> sortByLocation() {
        Set<Job> jobs = new HashSet<>(map.values());
        return jobs.stream()
                .sorted(Comparator.comparing(Job::getLocation))
                .collect(Collectors.toList());

    }

    @Override
    public Set<Job> getJobBySalary(int salary) {
        Set<Job> jobs = new HashSet<>(map.values());
        return jobs.stream()
                .filter(job -> job.getMinSalary() <= salary && job.getMaxSalary() > salary)
                .collect(Collectors.toSet());

    }

    @Override
    public Set<Job> getJobByKeyword(String keyword) {
        Set<Job> jobs = new HashSet<>(map.values());

        return jobs.stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase())
                        || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Job> getJobByLocationAndKeyWord(String location, String keyword) {
        Set<Job> jobsWithKeyword = getJobByKeyword(keyword);

        return jobsWithKeyword.stream()
                .filter(job -> job.getLocation().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toSet());

    }
}
