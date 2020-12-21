package omgtu.employment_agency.repo;

import omgtu.employment_agency.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepo extends JpaRepository<Vacancy, Long> {
}