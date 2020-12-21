package omgtu.employment_agency.repo;

import omgtu.employment_agency.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
}