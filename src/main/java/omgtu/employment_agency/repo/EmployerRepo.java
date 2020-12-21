package omgtu.employment_agency.repo;

import omgtu.employment_agency.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {
}