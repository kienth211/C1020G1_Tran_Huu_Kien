package com.casestudy.formatter;

import com.casestudy.model.employee.Position;
import com.casestudy.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PositionFormatter implements Formatter<Position> {
    @Autowired
    PositionService positionService;

    @Autowired
    public PositionFormatter(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public Position parse(String text, Locale locale) throws ParseException {
        return positionService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Position object, Locale locale) {
        return "[" + object.getPositionId() + ", " +object.getPositionName() + "]";
    }
}
