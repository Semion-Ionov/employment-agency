package omgtu.employment_agency.service;

import omgtu.employment_agency.model.Deal;
import omgtu.employment_agency.repo.DealRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    private final DealRepo dealRepo;

    public DealService(DealRepo dealRepo) {
        this.dealRepo = dealRepo;
    }

    public Deal findById(Long id) {
        return dealRepo.getOne(id);
    }

    public List<Deal> findAll() {
        return dealRepo.findAll();
    }

    public Deal save(Deal deal) {
        return dealRepo.save(deal);
    }

    public Deal update(Deal deal) {
        return dealRepo.save(deal);
    }

    public void deleteById(Long id) {
        dealRepo.deleteById(id);
    }
}
