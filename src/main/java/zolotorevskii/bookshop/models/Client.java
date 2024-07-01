package zolotorevskii.bookshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client_pkey_id")
    @SequenceGenerator(name = "seq_client_pkey_id", sequenceName = "seq_client_pkey_id", allocationSize = 1)
    private Long id;
    @Column( nullable = false)
    private String name;
    @Column( nullable = false)
    private Date birthday;
}
