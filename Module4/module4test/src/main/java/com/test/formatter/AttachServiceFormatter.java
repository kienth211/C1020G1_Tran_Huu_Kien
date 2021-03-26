//package com.test.formatter;
//
//import com.casestudy.model.contract.AttachService;
//import com.casestudy.service.contract.AttachServiceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//@Component
//public class AttachServiceFormatter implements Formatter<AttachService> {
//    @Autowired
//    AttachServiceService attachServiceService;
//
//    @Autowired
//    public AttachServiceFormatter(AttachServiceService attachServiceService) {
//        this.attachServiceService = attachServiceService;
//    }
//
//    @Override
//    public AttachService parse(String text, Locale locale) throws ParseException {
//        return attachServiceService.findById(Integer.parseInt(text));
//    }
//
//    @Override
//    public String print(AttachService object, Locale locale) {
//        return "[" + object.getAttachServiceId() + ", " +object.getAttachServiceName() + "]";
//    }
//}
//
//
