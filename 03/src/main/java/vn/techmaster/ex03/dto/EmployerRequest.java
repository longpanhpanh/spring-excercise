package vn.techmaster.ex03.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EmployerRequest {
    @NotEmpty(message = "Name must not be empty. Please try again")
    private String name;
}
