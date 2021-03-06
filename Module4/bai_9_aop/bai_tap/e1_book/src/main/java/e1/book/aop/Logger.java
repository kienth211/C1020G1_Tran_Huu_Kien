package e1.book.aop;

import e1.book.controller.BookController;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @After("execution(* e1.book.controller.BookController.borrowBook(*,*))")
    public void afterBorrowing(){
        LOGGER.info("borrow");
    }

    @After("execution(* e1.book.controller.BookController.returnBook(*,*))")
    public void afterReturning(){
        LOGGER.info("return");
    }
}