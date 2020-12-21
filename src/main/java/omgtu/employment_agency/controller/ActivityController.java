package omgtu.employment_agency.controller;

import omgtu.employment_agency.model.Activity;
import omgtu.employment_agency.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public String getActivities(Model model) {
        var activities = activityService.findAll();
        model.addAttribute("activities", activities);
        return "activities-list";
    }

    @GetMapping(path = "/{id}/edit")
    public String activityForm(@PathVariable("id") Long id, Model model) {
        var activity = (id == 0)
                       ? new Activity()
                       : activityService.findById(id);

        model.addAttribute("activity", activity);

        return "activities-form";
    }

    @PostMapping(path = "/save")
    public String saveActivity(Activity activity) {
        activityService.save(activity);
        return "redirect:/activities";
    }

    @GetMapping("/{id}/delete")
    public String deleteActivity(@PathVariable("id") Long id) {
        activityService.deleteById(id);
        return "redirect:/activities";
    }
}
