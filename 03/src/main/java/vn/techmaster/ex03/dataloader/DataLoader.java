package vn.techmaster.ex03.dataloader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.techmaster.ex03.model.Employer;
import vn.techmaster.ex03.repositories.EmployerRepository;
import vn.techmaster.ex03.repositories.JobRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployerRepository employerRepository;
    private final JobRepository jobRepository;

    public DataLoader(EmployerRepository employerRepository, JobRepository jobRepository) {
        this.employerRepository = employerRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employer emp1 = Employer.builder().id("E1").name("Fake Company 1").build();
        employerRepository.save(emp1);

        Employer emp2 = Employer.builder().id("E2").name("Fake Company 2").build();
        employerRepository.save(emp2);
    }
}
