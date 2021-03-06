package vn.techmaster.jobhunt.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.dto.EmployerRequest;
import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.service.EmployerService;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String listAllEmployers(Model model) {
        model.addAttribute("employers", employerService.getAllEmployers());
        return "employers";
    }

    @GetMapping("/{id}")
    public String showEmployerDetail(Model model, @PathVariable("id") String employerId) {
        model.addAttribute("employer", employerService.getEmployerById(employerId));
        return "employer";
    }

    @GetMapping("/add")
    public String showAddEmployerForm(Model model) {
        model.addAttribute("employerForm", new EmployerRequest());
        return "add-employer";
    }

    @PostMapping(value = "/add", consumes = { "multipart/form-data" })
    public String addEmployer(@Valid @ModelAttribute("employerForm") EmployerRequest employerRequest,
            BindingResult result, Locale locale, Model model) {
        if (employerRequest.getLogo().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("employerForm", "logo", messageSource.getMessage("employer.logo.notblank", null, locale)));
        }

        if (result.hasErrors()) {
            return "add-employer";
        }

        employerService.addEmployer(employerRequest);
        return "redirect:/employer";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployerById(@PathVariable("id") String employerId) {
        employerService.delete(employerId);
        return "redirect:/employer";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployerForm(@PathVariable("id") String employerId,
                                     Model model) {
        EmployerRequest employer = modelMapper.map(employerService.getEmployerById(employerId), EmployerRequest.class);
        model.addAttribute("employer", employer);
        return "edit-employer";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployerById(@Valid @ModelAttribute("employer") EmployerRequest employerRequest,
                                     BindingResult result, Locale locale, Model model) {
        if (employerRequest.getLogo().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("employerForm", "logo", messageSource.getMessage("employer.logo.notblank", null, locale)));
        }

        if (result.hasErrors()) {
            return "add-employer";
        }

        Employer employer = modelMapper.map(employerRequest, Employer.class);
        employerService.updateEmployer(employer);

        return "redirect:/employer";

    }
}
