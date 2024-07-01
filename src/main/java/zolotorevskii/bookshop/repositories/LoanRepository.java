package zolotorevskii.bookshop.repositories;

import zolotorevskii.bookshop.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
