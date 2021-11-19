package mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
//import org.springframework.web.bind.annotation.RequestParam;

//import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        //можно задать дефолтного работника
/*        Employee emp = new Employee();
        emp.setName("Ivan");
        emp.setSurname("Ivanov");
        emp.setSalary(500);
        //в атрибут добавить уже созданного
        model.addAttribute("employee", emp);*/
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }



    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
        //можно изменять поля
/*        String name = emp.getName();
        emp.setName("Mr " + name);

        String surname = emp.getSurname();
        emp.setSurname(surname + "!");

        int salary = emp.getSalary();
        emp.setSalary(salary * 10);*/
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return  "show-emp-details-view";
        }
    }

}

