package bg.softuni.linkedout.web;

import bg.softuni.linkedout.models.dto.AddEmployeeDTO;
import bg.softuni.linkedout.services.CompanyService;
import bg.softuni.linkedout.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeController {
    private final EmployeeService employeeService;

    private final CompanyService companyService;

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("availableCompanies", companyService.allCompanies());

        return "employee-add";
    }

    @ModelAttribute("employeeModel")
    public AddEmployeeDTO initEmployee() {
        return new AddEmployeeDTO();
    }

    @PostMapping("/add")
    public String addEmployee(@Valid AddEmployeeDTO employeeModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employeeModel", employeeModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeModel",
                    bindingResult);
            return "redirect:/employees/add";
        }
        employeeService.addEmployee(employeeModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllEmployees(Model model) {
        model.addAttribute("allEmployees", employeeService.allEmployees());

        return "employee-all";
    }

    @GetMapping("/employee-details{employee-full-name}")
    public String showEmployeeDetails(@PathVariable("employee-full-name") String employeeFullName, Model model) {
        model.addAttribute("employeeDetails", employeeService.employeeInfo(employeeFullName));

        return "employee-details";
    }

    @GetMapping("/employee-delete{employee-full-name}")
    public String deleteEmployee(@PathVariable("employee-full-name") String employeeFullName) {
        employeeService.fireEmployee(employeeFullName);

        return "redirect:/employees/all";
    }
}
