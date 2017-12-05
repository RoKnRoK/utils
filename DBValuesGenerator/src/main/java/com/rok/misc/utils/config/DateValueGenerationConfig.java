package com.rok.misc.utils.config;

import com.rok.misc.utils.ValueType;

import java.util.Date;

public class DateValueGenerationConfig implements ValueGenerationConfig {


    private static final String SQL_DATE_PATTERN = "yyyy-MM-dd";
    private Date startDate;
    private Date endDate;

    private String datePattern;

    public DateValueGenerationConfig(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.datePattern = SQL_DATE_PATTERN;
    }

    public DateValueGenerationConfig(Date startDate) {
        this.startDate = startDate;
        this.endDate = new Date();
        this.datePattern = SQL_DATE_PATTERN;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public DateValueGenerationConfig setDatePattern(String datePattern) {
        this.datePattern = datePattern;
        return this;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public ValueType getValueType() {
        return ValueType.DATE;
    }
}
