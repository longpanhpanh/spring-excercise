package vn.techmaster.ex03.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Employer {
    private Long id;
    private String name;

    @Builder
    public Employer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
