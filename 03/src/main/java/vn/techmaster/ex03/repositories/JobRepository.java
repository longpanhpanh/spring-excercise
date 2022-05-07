package vn.techmaster.ex03.repositories;

import org.springframework.stereotype.Repository;
import vn.techmaster.ex03.model.Employer;
import vn.techmaster.ex03.model.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JobRepository implements CrudRepository<Job> {

    private Map<Long, Job> repository;

    public JobRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Job job) {
        repository.put(job.getId(), job);
    }

    @Override
    public Job findById(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Job> getList() {
        return new ArrayList<>(repository.values());
    }
}
