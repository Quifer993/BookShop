package zolotorevskii.bookshop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zolotorevskii.bookshop.dto.BookDto;
import zolotorevskii.bookshop.dto.ClientDto;
import zolotorevskii.bookshop.services.ClientService;

@Controller
@RequiredArgsConstructor
@RequestMapping("clients")
@Slf4j
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping()
    public String getListPage(Model model) {
        model.addAttribute("clients", clientService.getAll());
        return "clients/list";
    }

    @GetMapping("add")
    public String addPage() {
        return "clients/add";
    }

    @PostMapping("add")
    public String add(ClientDto dto) {
        clientService.put(dto);
        log.info("Added client with id - {}", dto.getId());
        return "redirect:/clients";
    }

    @GetMapping("edit")
    public String editClientPage(Model model, ClientDto dto) throws Exception {
        model.addAttribute("client", dto);
        return "clients/edit";
    }

    @PostMapping("edit")
    public String edit(ClientDto dto) throws Exception {
        clientService.update(dto);
        log.info("Update client with id - {}", dto.getId());
        return "redirect:/clients";
    }

    @GetMapping("delete")
    public String delete(Long id) {
        clientService.delete(id);
        log.info("Deleted client with id - {}", id);
        return "redirect:/clients";
    }

}