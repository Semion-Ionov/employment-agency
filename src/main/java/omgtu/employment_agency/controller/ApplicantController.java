package omgtu.employment_agency.controller;

import omgtu.employment_agency.model.Applicant;
import omgtu.employment_agency.service.ActivityService;
import omgtu.employment_agency.service.ApplicantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;
    private final ActivityService activityService;

    public ApplicantController(ApplicantService applicantService, ActivityService activityService) {
        this.applicantService = applicantService;
        this.activityService = activityService;
    }

    @GetMapping
    public String getApplicants(Model model) {
        var applicants = applicantService.findAll();
        model.addAttribute("applicants", applicants);
        return "applicants-list";
    }

    @GetMapping(path = "/{id}/edit")
    public String applicantForm(@PathVariable("id") Long id, Model model) {
        var applicant = (id == 0)
                        ? new Applicant()
                        : applicantService.findById(id);

        model.addAttribute("applicant", applicant);
        model.addAttribute("activities", activityService.findAll());

        return "applicants-form";
    }

    @PostMapping(path = "/save")
    public String saveApplicant(Applicant applicant) {
        applicantService.save(applicant);
        return "redirect:/applicants";
    }

    @GetMapping("/{id}/delete")
    public String deleteApplicant(@PathVariable("id") Long id) {
        applicantService.deleteById(id);
        return "redirect:/applicants";
    }
}
