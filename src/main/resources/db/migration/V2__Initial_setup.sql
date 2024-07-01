CREATE TABLE book (
    name VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL,
    isbn VARCHAR(13) PRIMARY KEY
);

CREATE TABLE client (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL
);


CREATE TABLE loan (
    id BIGINT PRIMARY KEY,
    client BIGINT NOT NULL,
    book VARCHAR(13) NOT NULL,
    loan_date TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_client
        FOREIGN KEY(client)
        REFERENCES client(id),
    CONSTRAINT fk_book
        FOREIGN KEY(book)
        REFERENCES book(isbn),
    CONSTRAINT uniq_loan
        UNIQUE(book, client)
);



--INSERT INTO book (name, author, isbn) VALUES
--('Book1', 'Author1', 'ISBN000000001'),
--('Book2', 'Author2', 'ISBN000000002'),
--('Book3', 'Author3', 'ISBN000000003'),
--('Book4', 'Author4', 'ISBN000000004'),
--('Book5', 'Author5', 'ISBN000000005');
--
--INSERT INTO client (id, name, birthday) VALUES
--(1, 'Client1', '1980-01-01'),
--(2, 'Client2', '1990-02-02'),
--(3, 'Client3', '2000-03-03'),
--(4, 'Client4', '1970-04-04'),
--(5, 'Client5', '1985-05-05');
--
--INSERT INTO loan (id, client, book) VALUES
--(1, 1, 'ISBN000000001'),
--(2, 2, 'ISBN000000002'),
--(3, 3, 'ISBN000000003'),
--(4, 4, 'ISBN000000004'),
--(5, 5, 'ISBN000000005');
