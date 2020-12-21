package omgtu.employment_agency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@ToString(exclude = {"vacancy", "applicant"})
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @Column(name = "applicant_id")
    private Long applicantId;

    private Date date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Vacancy vacancy;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Applicant applicant;
}