package omgtu.employment_agency.controller;

import omgtu.employment_agency.model.Employer;
import omgtu.employment_agency.service.EmployerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/employers")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public String getEmployers(Model model) {
        var employers = employerService.findAll();
        model.addAttribute("employers", employers);
        return "employers-list";
    }

    @GetMapping(path = "/{id}/edit")
    public String employerForm(@PathVariable("id") Long id, Model model) {
        var employer = (id == 0)
                        ? new Employer()
                        : employerService.findById(id);

        model.addAttribute("employer", employer);

        return "employers-form";
    }

    @PostMapping(path = "/save")
    public String saveEmployert(Employer employer) {
        employerService.save(employer);
        return "redirect:/employers";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployer(@PathVariable("id") Long id) {
        employerService.deleteById(id);
        return "redirect:/employers";
    }
}
