package com.casestudy.formatter;

import com.casestudy.model.employee.Division;
import com.casestudy.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class DivisionFormatter implements Formatter<Division> {
    @Autowired
    DivisionService divisionService;

    @Autowired
    public DivisionFormatter(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @Override
    public Division parse(String text, Locale locale) throws ParseException {
        return divisionService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Division object, Locale locale) {
        return "[" + object.getDivisionId() + ", " +object.getDivisionName() + "]";
    }
}
