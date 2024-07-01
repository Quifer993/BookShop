package zolotorevskii.bookshop.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import zolotorevskii.bookshop.dto.BookDto;
import zolotorevskii.bookshop.dto.ClientDto;
import zolotorevskii.bookshop.dto.LoanDto;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.models.Client;
import zolotorevskii.bookshop.models.Loan;
import org.springframework.stereotype.Service;
import zolotorevskii.bookshop.repositories.BookRepository;
import zolotorevskii.bookshop.repositories.ClientRepository;
import zolotorevskii.bookshop.repositories.LoanRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class LoanService {
    LoanRepository loanRepository;
    BookRepository bookRepository;
    ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public void put(String isbn, Long clientId) {
        Loan loan = new Loan();
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        Optional<Client> clientOptional = clientRepository.findById(clientId);

        if(bookOptional.isPresent() && clientOptional.isPresent()){
            loan.setBook(bookOptional.get());
            loan.setClient(clientOptional.get());
            loanRepository.save(loan);
        }
    }

    public List<LoanDto> getAll(){
        return loanRepository.findAll().stream()
                .map((element) -> modelMapper.map(element, LoanDto.class))
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map((element) -> modelMapper.map(element, BookDto.class))
                .collect(Collectors.toList());
    }
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map((element) -> modelMapper.map(element, ClientDto.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        loanRepository.findById(id).ifPresent(loanRepository::delete);
    }
}
