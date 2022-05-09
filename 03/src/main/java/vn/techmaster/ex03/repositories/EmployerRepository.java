package vn.techmaster.ex03.repositories;

import org.springframework.stereotype.Repository;
import vn.techmaster.ex03.model.Employer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EmployerRepository implements CrudRepository<Employer> {

    private Map<String , Employer> repository;

    public EmployerRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Employer employer) {
        repository.put(employer.getId(), employer);
    }

    @Override
    public Employer findById(String id) {
        return repository.get(id);
    }

    @Override
    public List<Employer> getList() {
        return new ArrayList<>(repository.values());
    }


}
