package zolotorevskii.bookshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class ClientDto {
    private Long id;
    private String name;
    private Date birthday;
}
