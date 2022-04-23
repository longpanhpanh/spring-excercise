package vn.techmaster.ex02.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.techmaster.ex02.model.Job;
import vn.techmaster.ex02.model.Location;
import vn.techmaster.ex02.services.JobService;

@Component
public class DataLoader implements CommandLineRunner {

    private final JobService jobService;

    public DataLoader(JobService jobService) {
        this.jobService = jobService;
    }


    @Override
    public void run(String... args) throws Exception {
        Job job1 = new Job("J1",
                "Junior Backend Developer",
                "Spring, J2EE, NodeJs, PHP Lavarel",
                Location.HA_NOI.value,
                500,
                800, "backend@recruit.com");

        jobService.addJob(job1);

        Job job2 = new Job("J2",
                "Junior Frontend Developer",
                "ReactJs, VueJs, AngularJs",
                Location.HO_CHI_MINH.value,
                500,
                700, "frontend@recruit.com");

        jobService.addJob(job2);


        Job job3 = new Job("J3",
                "Junior DevOps",
                "Docker, K8s",
                Location.DA_NANG.value,
                500,
                700, "devops@recruit.com");

        jobService.addJob(job3);

        System.out.println("Loaded Jobs...");

    }
}
