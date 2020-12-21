package omgtu.employment_agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"deals", "employer", "activity"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "experience_years")
    private Integer experienceYears;

    private Integer wage;

    @JsonIgnore
    @OneToMany(mappedBy = "vacancy",
               fetch = FetchType.LAZY)
    private List<Deal> deals;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employer employer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;
}