package e1.book.controller;

import e1.book.service.exception.MaxQuantity;
import e1.book.service.exception.OutOfStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import e1.book.model.Book;
import e1.book.service.BookService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ModelAndView showHome(@PageableDefault(size = 5) Pageable pageable) {
        Page<Book> books;
        books = bookService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam String borrowCode, RedirectAttributes redirectAttributes)
            throws OutOfStock, MaxQuantity {
        Book book = bookService.findByBorrowCode(borrowCode);
        book.setRemainingAmount(book.getRemainingAmount() - 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("messenger", "Book borrowed successful");
        return "redirect:/";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam(required = false) String borrowCode, RedirectAttributes redirectAttributes)
            throws OutOfStock, MaxQuantity {
        if (bookService.findByBorrowCode(borrowCode) == null){
            return "/book-not-found";
        } else {
            Book book = bookService.findByBorrowCode(borrowCode);
            book.setRemainingAmount(book.getRemainingAmount() + 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("messenger", "Book returned successful");
            return "redirect:/";
        }
    }

    @ExceptionHandler(OutOfStock.class)
    public ModelAndView outOfStock(){
        return new ModelAndView("out-of-stock");
    }

    @ExceptionHandler(MaxQuantity.class)
    public ModelAndView maxQuantity(){
        return new ModelAndView("max-quantity");
    }
}
