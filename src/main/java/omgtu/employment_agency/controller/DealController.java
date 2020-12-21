package omgtu.employment_agency.controller;

import omgtu.employment_agency.model.Deal;
import omgtu.employment_agency.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/deals")
public class DealController {
    private final DealService dealService;
    private final VacancyService vacancyService;
    private final ApplicantService applicantService;

    public DealController(DealService dealService,
                          VacancyService vacancyService,
                          ApplicantService applicantService) {
        this.dealService = dealService;
        this.vacancyService = vacancyService;
        this.applicantService = applicantService;
    }

    @GetMapping
    public String getDeals(Model model) {
        var deals = dealService.findAll();
        model.addAttribute("deals", deals);
        return "deals-list";
    }

    @GetMapping(path = "/{id}/edit")
    public String dealForm(@PathVariable("id") Long id, Model model) {
        var deal = (id == 0)
                      ? new Deal()
                      : dealService.findById(id);

        model.addAttribute("deal", deal);
        model.addAttribute("vacancies", vacancyService.findAll());
        model.addAttribute("applicants", applicantService.findAll());

        return "deals-form";
    }

    @PostMapping(path = "/save")
    public String saveDeal(Deal deal) {
        dealService.save(deal);
        return "redirect:/deals";
    }

    @GetMapping("/{id}/delete")
    public String deleteDeal(@PathVariable("id") Long id) {
        dealService.deleteById(id);
        return "redirect:/deals";
    }
}
