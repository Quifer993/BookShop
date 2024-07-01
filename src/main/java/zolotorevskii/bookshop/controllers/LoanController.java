package zolotorevskii.bookshop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zolotorevskii.bookshop.services.LoanService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("loans")
@Slf4j
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping("add")
    public String addLoan(Model model) {
        model.addAttribute("books", loanService.getAllBooks());
        model.addAttribute("clients", loanService.getAllClients());
        return "loans/add";
    }

    @PostMapping("loan")
    public String loan(@RequestParam("isbn") String isbn, @RequestParam("client") Long clientId){
        loanService.put(isbn, clientId);
        log.info("Added loan with isbn - {}, clientId - {}", isbn, clientId);
        return "redirect:/loans";
    }

    @GetMapping()
    public String getLoans(Model model) {
        model.addAttribute("loans", loanService.getAll());
        return "loans/list";
    }

    @GetMapping("delete")
    public String deleteLoan(Long id) throws Exception {
        loanService.delete(id);
        log.info("Deleted loan with id - {}", id);
        return "redirect:/loans";
    }

}