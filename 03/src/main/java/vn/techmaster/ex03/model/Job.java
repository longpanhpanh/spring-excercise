package vn.techmaster.ex03.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Job {
    private Long id;
    private String title;

    @Builder
    public Job(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
