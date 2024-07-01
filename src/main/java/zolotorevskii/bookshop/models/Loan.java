package zolotorevskii.bookshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "loan",
      uniqueConstraints = @UniqueConstraint(name = "uniq_loan", columnNames = {"book", "client"}))
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loan_pkey_id")
    @SequenceGenerator(name = "seq_loan_pkey_id", sequenceName = "seq_loan_pkey_id", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", nullable = false)
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book",nullable = false)
    private Book book;
    @Column(nullable = false, updatable = false)
    private LocalDateTime loanDate;

    @PrePersist
    protected void onCreate() {
        loanDate = LocalDateTime.now();
    }
}
