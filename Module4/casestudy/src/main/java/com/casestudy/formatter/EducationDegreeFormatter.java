package com.casestudy.formatter;

import com.casestudy.model.employee.EducationDegree;
import com.casestudy.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class EducationDegreeFormatter implements Formatter<EducationDegree> {
    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    public EducationDegreeFormatter(EducationDegreeService educationDegreeService) {
        this.educationDegreeService = educationDegreeService;
    }

    @Override
    public EducationDegree parse(String text, Locale locale) throws ParseException {
        return educationDegreeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(EducationDegree object, Locale locale) {
        return "[" + object.getEducationDegreeId() + ", " +object.getEducationDegreeName() + "]";
    }
}
