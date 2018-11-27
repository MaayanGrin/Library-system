/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Maayan
 */
public class helper {
    
    
      public static boolean isNullOrEmpty(String s) {
        if(s == null)
            return true;
        return s.isEmpty();
    }
        public  Date settimetake(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        dt = c.getTime();
        return dt;
    }
    public Date settimeback(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, 5);
        dt = c.getTime();
        return dt;
    }
    
    public Date constringdate(String s){
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateInString = s;
        Date date=null;
        try {

            date = formatter.parse(dateInString);
         //   System.out.println(date);
         //   System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
