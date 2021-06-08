package nlu.project.cdweb.custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class MyDateFormat {
	String date;
	public static String convert(String s) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(s);
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            result = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
	}
	public static String reconvert(String s) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(s);
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            result = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
	}
	
	// jsp usebean tag
	public String getDate() {
		return reconvert(date);
	}
	public void setDate(String date) {
		this.date = date;
	}

	public static String getNow(){
        LocalDateTime ldt = LocalDateTime.now();
        String dateCreate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
        return dateCreate;
    }
	
}
