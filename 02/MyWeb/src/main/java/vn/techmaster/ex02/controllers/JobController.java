package vn.techmaster.ex02.controllers;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.ex02.model.Job;
import vn.techmaster.ex02.services.JobServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobServiceImpl jobServiceImpl;

    public JobController(JobServiceImpl jobServiceImpl) {
        this.jobServiceImpl = jobServiceImpl;
    }


    @GetMapping
    public Set<Job> getJobs() {
        return jobServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") String id) {
        return jobServiceImpl.findById(id);
    }


    @GetMapping("/sortbylocation")
    public List<Job> getSortedJobs() {
        return jobServiceImpl.sortByLocation();
    }

    @GetMapping("/salary/{salary}")
    public Set<Job> getJobsBySalary(@PathVariable("salary") int salary) {
        return jobServiceImpl.getJobBySalary(salary);
    }

    @GetMapping("/keyword/{keyword}")
    public Set<Job> getJobsByKeyword(@PathVariable("keyword") String keyword) {
        return jobServiceImpl.getJobByKeyword(keyword);
    }

    @GetMapping("/query")
    public Set<Job> getJobsByLocationAndKeyword(@RequestParam("location") String location,
                                                @RequestParam("keyword") String keyword) {
        return jobServiceImpl.getJobByLocationAndKeyWord(location, keyword);
    }

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobServiceImpl.addJob(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable("id") String id, @RequestBody Job job) {
        return jobServiceImpl.updateById(id, job);
    }

    @DeleteMapping("/{id}")
    public Job deleteJob(@PathVariable("id") String id) {
        return jobServiceImpl.deleteById(id);
    }





}
