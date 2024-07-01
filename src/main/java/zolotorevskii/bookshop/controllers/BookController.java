package zolotorevskii.bookshop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zolotorevskii.bookshop.dto.BookDto;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("books")
@Slf4j
public class BookController {
    @Autowired
    BooksService booksService;

    @GetMapping()
    public String getListPage(Model model) {
        model.addAttribute("books", booksService.getAll());
        return "books/list";
    }

    @GetMapping("add")
    public String addPage() {
        return "books/add";
    }

    @PostMapping("add")
    public String addBook(BookDto book) {
        if(booksService.put(book)){
            return "redirect:/books/add";
        }
        log.info("Added book with isbn - {}", book.getIsbn());
        return "redirect:/books";
    }

    @GetMapping("edit")
    public String editBookPage(Model model, BookDto book) throws Exception {
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("edit")
    public String editBook(BookDto book) throws Exception {
        booksService.update(book);
        log.info("Updated book with isbn - {}", book.getIsbn());
        return "redirect:/books";
    }

    @GetMapping("delete")
    public String delete(String isbn) {
        booksService.delete(isbn);
        log.info("Deleted book with isbn - {}", isbn);
        return "redirect:/books";
    }
}