package vn.techmaster.ex03.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Job {
    private String id;
    private String title;

    @Builder
    public Job(String id, String title) {
        this.id = id;
        this.title = title;
    }
}
