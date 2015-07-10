package com.restful.resources;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

    // the desired format
    private String pattern = "yyyyMMddhhmmss";
    
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat(pattern).format(date);
    }
    
    public Date unmarshal(String dateString) throws Exception {
        return new SimpleDateFormat(pattern).parse(dateString);
    }
}
