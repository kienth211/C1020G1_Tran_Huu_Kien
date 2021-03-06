package e1.book.service.impl;

import e1.book.model.Book;
import e1.book.repository.BookRepository;
import e1.book.service.BookService;
import e1.book.service.exception.MaxQuantity;
import e1.book.service.exception.OutOfStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findByBorrowCode(String borrowCode) {
        return bookRepository.findByBorrowCode(borrowCode);
    }

    @Override
    public void save(Book book) throws OutOfStock, MaxQuantity {
        if (book.getRemainingAmount() < 0) {
            book.setRemainingAmount(book.getRemainingAmount() + 1);
            throw new OutOfStock("Out of stock");
        }
        else if (book.getRemainingAmount() > book.getMaxQuantity()) {
            book.setRemainingAmount(book.getRemainingAmount() - 1);
            throw new MaxQuantity("Max quantity");
        }
        else {
            bookRepository.save(book);
        }
    }
}
