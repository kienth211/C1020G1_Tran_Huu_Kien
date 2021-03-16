package com.casestudy.formatter;

import com.casestudy.model.service.RentType;
import com.casestudy.service.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RentTypeFormatter implements Formatter<RentType> {
    @Autowired
    RentTypeService rentTypeService;

    @Autowired
    public RentTypeFormatter(RentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @Override
    public RentType parse(String text, Locale locale) throws ParseException {
        return rentTypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(RentType object, Locale locale) {
        return "[" + object.getRentTypeId() + ", " +object.getRentTypeName() + "]";
    }
}
