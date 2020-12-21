package omgtu.employment_agency.service;

import omgtu.employment_agency.model.Employer;
import omgtu.employment_agency.repo.EmployerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepo employerRepo;

    public EmployerService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }

    public Employer findById(Long id) {
        return employerRepo.getOne(id);
    }

    public List<Employer> findAll() {
        return employerRepo.findAll();
    }

    public Employer save(Employer employer) {
        return employerRepo.save(employer);
    }

    public Employer update(Employer employer) {
        return employerRepo.save(employer);
    }

    public void deleteById(Long id) {
        employerRepo.deleteById(id);
    }
}
