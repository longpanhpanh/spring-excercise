package vn.techmaster.ex03.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Applicant {
    private Long id;
    private String name;
    private String position;

    @Builder
    public Applicant(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
