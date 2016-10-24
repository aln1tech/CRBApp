package org.az.app.confRoomBook.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM,yyyy HH:mm:ss");
    
    private DateUtil() {
        
    }
    
    public static String convertDate(long date) {
        
        return dateFormat.format(new Date(date));
        
    }
    
    public static String convertDate(SimpleDateFormat formater, long date) {
        if(formater == null) {
            return null;
        }
        return formater.format(new Date(date));
    }
  
    public static String convertStrFromDate(Date date, SimpleDateFormatEnum sdfEnum) throws ParseException {
        if(date != null) {
            try {            	
                return sdfEnum.getSdf().format(date);
            } catch (Exception e) {
                return dateFormat.format(date);
            }
        }
        
        return null;
        
    }
    public static Date convertDateFromStr(String date, SimpleDateFormatEnum sdfEnum) throws ParseException {
        if(date != null) {
            try {            	
                return sdfEnum.getSdf().parse(date);
            } catch (Exception e) {
                return dateFormat.parse(date);
            }
        }
        
        return null;
        
    }
    
    public static String convertDate(String date, SimpleDateFormatEnum sdfEnum) {
        if(date != null) {
            try {
                return sdfEnum.getSdf().format(date);
            } catch (Exception e) {
                return dateFormat.format(date);
            }
        }
        
        return null;
        
    }    
    
    public enum SimpleDateFormatEnum {
        
        yyyyMMdd("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd")),
        
        yyyyMMMdd("yyyy-MM-dd", new SimpleDateFormat("yyyy-MMM-dd")),
        
        yyyyMMMdd_HHMMSS("yyyyMMMdd_HHMMSS", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")),
        
        yyyyMMMdd_235959("yyyyMMMdd_235959", new SimpleDateFormat("yyyy-MM-dd 23:59:59")),
        
        yyyyMMMdd_HHMM("yyyyMMMdd_HHMM", new SimpleDateFormat("yyyy-MM-dd HH:mm")),
        
        ddMMMyyyy("ddMMMyyyy", new SimpleDateFormat("dd MMM,yyyy")),
        
        dd("dd", new SimpleDateFormat("dd")),
        
        DMMMYYYYHHmmss("d MMM,yyyy HH:mm:ss", new SimpleDateFormat("d MMM,yyyy HH:mm:ss")),
        
        yyyyMMMddTHHMMSS("yyyyMMMdd_HHMMSS", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")),
        
        hhmmss("HH:mm:ss" , new SimpleDateFormat("HH:mm:ss")),
        
        DDMMMYYYYHHmmss("dd MMM,yyyy HH:mm:ss", new SimpleDateFormat("dd MMM,yyyy HH:mm:ss")),;
        
        String pattern;
        SimpleDateFormat sdf;
        
        /**
         * @return the pattern
         */
        public String getPattern() {
            return pattern;
        }
        
        /**
         * @param pattern
         *            the pattern to set
         */
        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
        
        /**
         * @return the sdf
         */
        public SimpleDateFormat getSdf() {
            return sdf;
        }
        
        /**
         * @param sdf
         *            the sdf to set
         */
        public void setSdf(SimpleDateFormat sdf) {
            this.sdf = sdf;
        }
        
        /**
         * 
         */
        private SimpleDateFormatEnum(String pattern, SimpleDateFormat sdf) {
            this.pattern = pattern;
            this.sdf = sdf;
        }
        
    }    
    
}
