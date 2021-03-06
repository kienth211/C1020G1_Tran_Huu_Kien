package e1.book.service;

import e1.book.model.Book;
import e1.book.service.exception.MaxQuantity;
import e1.book.service.exception.OutOfStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findByBorrowCode(String borrowCode);
    void save(Book book) throws OutOfStock, MaxQuantity;
}
