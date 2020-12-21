package omgtu.employment_agency.controller;

import omgtu.employment_agency.model.Vacancy;
import omgtu.employment_agency.service.ActivityService;
import omgtu.employment_agency.service.EmployerService;
import omgtu.employment_agency.service.VacancyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vacancies")
public class VacancyController {
    private final VacancyService vacancyService;
    private final ActivityService activityService;
    private final EmployerService employerService;

    public VacancyController(VacancyService vacancyService, ActivityService activityService, EmployerService employerService) {
        this.vacancyService = vacancyService;
        this.activityService = activityService;
        this.employerService = employerService;
    }

    @GetMapping
    public String getVacancies(Model model) {
        var vacancies = vacancyService.findAll();
        model.addAttribute("vacancies", vacancies);
        return "vacancies-list";
    }

    @GetMapping(path = "/{id}/edit")
    public String vacancyForm(@PathVariable("id") Long id, Model model) {
        var vacancy = (id == 0)
                        ? new Vacancy()
                        : vacancyService.findById(id);

        model.addAttribute("vacancy", vacancy);
        model.addAttribute("activities", activityService.findAll());
        model.addAttribute("employers", employerService.findAll());

        return "vacancies-form";
    }

    @PostMapping(path = "/save")
    public String saveVacancy(Vacancy vacancy) {
        vacancyService.save(vacancy);
        return "redirect:/vacancies";
    }

    @GetMapping("/{id}/delete")
    public String deleteVacancy(@PathVariable("id") Long id) {
        vacancyService.deleteById(id);
        return "redirect:/vacancies";
    }
}
