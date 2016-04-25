package com.vw.dilab.amspreeufer.library.patrons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/patrons")
public class PatronsController {
    private PatronsRepositoryInterface patronsRepo;

    @Autowired
    public PatronsController(PatronsRepositoryInterface patronsRepo) {
        this.patronsRepo = patronsRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView showPatrons(@ModelAttribute("model") ModelMap model) {

        model.addAttribute("patronsList", patronsRepo.fetchAll());
        return new ModelAndView("patrons_view", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/csv")
    public String showAllAsCSV(HttpServletResponse response, @ModelAttribute("model") ModelMap model) {

        response.setContentType("text/csv");
        response.setHeader("Content-disposition", "attachment; filename=patrons.csv");

        model.addAttribute("patronsList", patronsRepo.fetchAll());
        return "patrons_as_csv";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addPatron(@ModelAttribute("model") ModelMap model, @RequestParam String patron_name, @RequestParam String patron_email) {

        Patron newPatron = Patron.builder()
                .name(patron_name)
                .email(patron_email)
                .build();
        patronsRepo.storePatron(newPatron);

        model.addAttribute("patronsList", patronsRepo.fetchAll());
        return "patrons_view";
    }
}




