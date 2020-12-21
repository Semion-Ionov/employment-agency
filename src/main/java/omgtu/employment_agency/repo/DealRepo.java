package omgtu.employment_agency.repo;

import omgtu.employment_agency.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepo extends JpaRepository<Deal, Long> {
}