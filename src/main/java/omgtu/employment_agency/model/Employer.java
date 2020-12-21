package omgtu.employment_agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"vacancies"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "employer",
               fetch = FetchType.LAZY)
    private List<Vacancy> vacancies;
}