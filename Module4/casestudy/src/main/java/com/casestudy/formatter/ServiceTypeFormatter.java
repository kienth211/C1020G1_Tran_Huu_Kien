package com.casestudy.formatter;

import com.casestudy.model.service.ServiceType;
import com.casestudy.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ServiceTypeFormatter implements Formatter<ServiceType> {
    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeFormatter(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @Override
    public ServiceType parse(String text, Locale locale) throws ParseException {
        return serviceTypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(ServiceType object, Locale locale) {
        return "[" + object.getServiceTypeId() + ", " +object.getServiceTypeName() + "]";
    }
}
