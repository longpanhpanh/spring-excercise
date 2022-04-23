package vn.techmaster.ex02.controllers;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.ex02.model.Job;
import vn.techmaster.ex02.services.JobService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping
    public Set<Job> getJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") String id) {
        return jobService.findById(id);
    }


    @GetMapping("/sortbylocation")
    public List<Job> getSortedJobs() {
        return jobService.sortByLocation();
    }

    @GetMapping("/salary/{salary}")
    public Set<Job> getJobsBySalary(@PathVariable("salary") int salary) {
        return jobService.getJobBySalary(salary);
    }

    @GetMapping("/keyword/{keyword}")
    public Set<Job> getJobsByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.getJobByKeyword(keyword);
    }

    @GetMapping("/query")
    public Set<Job> getJobsByLocationAndKeyword(@RequestParam("location") String location,
                                                @RequestParam("keyword") String keyword) {
        return jobService.getJobByLocationAndKeyWord(location, keyword);
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable("id") String id, @RequestBody Job job) {
        return jobService.updateById(id, job);
    }

    @DeleteMapping("/{id}")
    public Job deleteJob(@PathVariable("id") String id) {
        return jobService.deleteById(id);
    }





}
