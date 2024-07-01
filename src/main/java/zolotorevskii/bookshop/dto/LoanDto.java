package zolotorevskii.bookshop.dto;

import lombok.Getter;
import lombok.Setter;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.models.Client;

import java.time.LocalDateTime;

@Setter
@Getter
public class LoanDto {
    private Long id;
    private Client client;
    private Book book;
    private LocalDateTime loanDate;
}
