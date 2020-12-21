package omgtu.employment_agency.service;

import omgtu.employment_agency.model.Vacancy;
import omgtu.employment_agency.repo.VacancyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    private final VacancyRepo vacancyRepo;

    public VacancyService(VacancyRepo vacancyRepo) {
        this.vacancyRepo = vacancyRepo;
    }

    public Vacancy findById(Long id) {
        return vacancyRepo.getOne(id);
    }

    public List<Vacancy> findAll() {
        return vacancyRepo.findAll();
    }

    public Vacancy save(Vacancy vacancy) {
        return vacancyRepo.save(vacancy);
    }

    public Vacancy update(Vacancy vacancy) { return vacancyRepo.save(vacancy); }

    public void deleteById(Long id) {
        vacancyRepo.deleteById(id);
    }
}
