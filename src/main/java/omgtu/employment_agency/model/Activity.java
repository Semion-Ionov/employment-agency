package omgtu.employment_agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"applicants", "vacancies"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "activity",
               fetch = FetchType.LAZY)
    private List<Applicant> applicants;

    @JsonIgnore
    @OneToMany(mappedBy = "activity",
               fetch = FetchType.LAZY)
    private List<Vacancy> vacancies;
}

