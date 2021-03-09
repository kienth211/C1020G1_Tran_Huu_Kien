package e1.book.aop;

import e1.book.controller.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @AfterReturning(pointcut = "execution(public * e1.book.controller.BookController.borrowBook*(..))")
    public void afterBorrowing(JoinPoint joinPoint){
        LOGGER.debug("borrow book have borrowCode: " + joinPoint.getArgs()[0]);
    }

    @After("execution(* e1.book.controller.BookController.returnBook(*,*))")
    public void afterReturning(JoinPoint joinPoint){
        LOGGER.debug("return book have borrowCode: " + joinPoint.getArgs()[0]);
    }
}