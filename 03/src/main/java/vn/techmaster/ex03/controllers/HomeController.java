package vn.techmaster.ex03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.techmaster.ex03.dto.EmployerRequest;
import vn.techmaster.ex03.model.Employer;
import vn.techmaster.ex03.repositories.EmployerRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {
    private final EmployerRepository employerRepository;

    public HomeController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/employers")
    public String getEmployers(Model model) {
        List<Employer> employers = employerRepository.getList();
        model.addAttribute("employers", employers);
        return "employer/employer-list";
    }

    @GetMapping("/employers/add")
    public String getEmployerForm(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        return "employer/add";
    }

    @PostMapping("/employers")
    public String addNewEmployer(@ModelAttribute("employerRequest") @Valid EmployerRequest emp, BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "employer/add";
        }

        String id = UUID.randomUUID().toString();
        Employer newEmp = Employer.builder()
                .id(id)
                .name(emp.getName())
                .build();

        model.addAttribute("employerRequest", newEmp);
        employerRepository.save(newEmp);

        return "redirect:/employers";

    }
}
