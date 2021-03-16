package com.casestudy.formatter;

import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CustomerTypeFormatter implements Formatter<CustomerType> {
    @Autowired
    CustomerTypeService customerTypeService;

    @Autowired
    public CustomerTypeFormatter(CustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @Override
    public CustomerType parse(String text, Locale locale) throws ParseException {
        return customerTypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(CustomerType object, Locale locale) {
        return "[" + object.getCustomerTypeId() + ", " +object.getCustomerTypeName() + "]";
    }
}
