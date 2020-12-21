package omgtu.employment_agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@ToString(exclude = {"deal", "activity"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(columnDefinition = "ENUM('M', 'F')")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String phone;

    @Column(name="experience_years")
    private Integer experienceYears;

    @JsonIgnore
    @OneToOne(mappedBy = "applicant",
              fetch = FetchType.LAZY)
    private Deal deal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;

    private enum Sex {
        M, F
    }
}