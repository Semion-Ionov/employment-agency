package omgtu.employment_agency.service;

import omgtu.employment_agency.model.Applicant;
import omgtu.employment_agency.repo.ApplicantRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepo applicantRepo;

    public ApplicantService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    public Applicant findById(Long id) {
        return applicantRepo.getOne(id);
    }

    public List<Applicant> findAll() {
        return applicantRepo.findAll();
    }

    public Applicant save(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public Applicant update(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public void deleteById(Long id) {
        applicantRepo.deleteById(id);
    }
}

