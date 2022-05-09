package vn.techmaster.ex03.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Employer {
    private String id;
    private String name;

    @Builder
    public Employer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
