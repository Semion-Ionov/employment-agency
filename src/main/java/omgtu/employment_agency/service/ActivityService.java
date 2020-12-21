package omgtu.employment_agency.service;

import omgtu.employment_agency.model.Activity;
import omgtu.employment_agency.repo.ActivityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepo activityRepo;

    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public Activity findById(Long id) {
        return activityRepo.getOne(id);
    }

    public List<Activity> findAll() {
        return activityRepo.findAll();
    }

    public Activity save(Activity activity) {
        return activityRepo.save(activity);
    }

    public Activity update(Activity activity) {
        return activityRepo.save(activity);
    }

    public void deleteById(Long id) {
        activityRepo.deleteById(id);
    }
}
