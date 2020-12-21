package omgtu.employment_agency.repo;

import omgtu.employment_agency.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
}