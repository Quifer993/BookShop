package zolotorevskii.bookshop.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zolotorevskii.bookshop.dto.BookDto;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class BooksService {
    BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public boolean put(BookDto bookDto) {
        boolean isExist = bookRepository.findById(bookDto.getIsbn()).isPresent();
        if(!isExist){
            saveBook(bookDto);
        }
        return isExist;
    }
    public void update(BookDto bookDto) throws Exception {
        String isbn = bookDto.getIsbn();
        bookRepository.findById(isbn).orElseThrow(() -> new Exception("Book with isbn: (" + isbn + ")is missing."));
        saveBook(bookDto);
    }

    private void saveBook(BookDto bookDto){
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        bookRepository.save(book);
    }

    public List<BookDto> getAll(){
        return bookRepository.findAll().stream().
                map((element) -> modelMapper.map(element, BookDto.class))
                .collect(Collectors.toList());
    }

    public void delete(String isbn) {
        bookRepository.findById(isbn).ifPresent(bookRepository::delete);
    }
}
