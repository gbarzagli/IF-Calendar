package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
	
	public static String encrypt(String text) {
		return DigestUtils.md5Hex(text);
	}
	
	public static String[][] getMonthDays(int month, int year) {
	    String[][] days = {
	            {"","","","","","",""},
	            {"","","","","","",""},
	            {"","","","","","",""},
	            {"","","","","","",""},
	            {"","","","","","",""},
	            {"","","","","","",""}
	    };
	    
	    LocalDate firstDay = LocalDate.of(year, month, 1);
	    DayOfWeek dayOfWeek = firstDay.getDayOfWeek();
	    int column = dayOfWeek.getValue();
	    int line = 0;
	    
	    boolean isLeap = Year.isLeap(year);
	    int length = firstDay.getMonth().length(isLeap);
	    
	    for (int i = 1; i <= length; i++) {
	        if (column == 7) {
	            column = 0;
	            line++;
	        }
	        
	        days[line][column] = Integer.toString(i);
	        column++;
	    }
	    
	    return days;
	}
	
//	public static void main(String[] args) {
//        String[][] days =  getMonthDays(Month.NOVEMBER.getValue(), 2017);
//        
//        for(int i = 0; i < 6; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print("| " + days[i][j] + " |");
//            }
//            System.out.println();
//        }
//    }
	
}
