package zolotorevskii.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.models.Client;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
