package SSLAlert;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Utility.SMS_Send;
import Utility.Sendmail;

import Utility.SendmailSSL;
public class SSL_Alert {
	
	 private final static long ONCE_PER_DAY = 1000*60*60*24;

	    //private final static int ONE_DAY = 1;
	    private final static int TWO_PM = 2;
	    private final static int ZERO_MINUTES = 0;
	    
	    public void run() {
	        long currennTime = System.currentTimeMillis();
	        long stopTime = currennTime + 20;//provide the 2hrs time it should execute 1000*60*60*2
	          while(stopTime != System.currentTimeMillis()){
	        	  
	        	  
	        	  System.out.println("Start Job"+stopTime);
	              System.out.println("End Job"+System.currentTimeMillis());
	            }
	      }
	          
	   @Test
	   public void verify_SSL_certificate() throws FileNotFoundException {
		//public static void main(String[] args) throws FileNotFoundException {
			startTask();
			AlertURLverify(); 
	   
}
		
	
	private static void AlertURLverify() throws FileNotFoundException {
		String filename = "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Regression\\src\\test\\sslcertsdomain.csv";
        
		File file= new File(filename);
	
        Scanner scan = new Scanner(new File(filename));
        ArrayList<String[]> records = new ArrayList<String[]>();
        String[] record = new String[2];
        while(scan.hasNext())
        {
            record = scan.nextLine().split(",");
            records.add(record);
        }
        int data =record.length;
        data = 96;
     //  for(int i = 1; i < records.size(); i++)
    	   for(int i = 1; i <data; i++)
    	   for(int j = 0; j < 1; j++)
           {
          //   System.out.print(records.get(i)[j] + " ");
               String domainnme = (records.get(i)[0]);
               String todate = (records.get(i)[3]);
               String Fromdate = (records.get(i)[2]);
               String Alertdate = (records.get(i)[4]);
          //  System.out.println(todate);
               
            //   TestDate();
               SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");		
      		 LocalDateTime ldt = LocalDateTime.now();
      		 String currentdate = (DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(ldt));
      		  Oneweekalertemail();     
      	     		 
			if (Alertdate.compareTo(currentdate) == 0) {					
                  SendmailSSL.sendmail("SSL Domain Name Alert  :"+domainnme +   "Domain from date:"+ Fromdate +  " Expired date :"+todate);
               }  if (todate.compareTo(currentdate) == 3) {
            	           	           	   
            	  SendmailSSL.sendmail("SSL Domain Name Alert  :"+domainnme +   "Domain from date:"+ Fromdate +  " Expired date :"+todate);
             //  SMS_Send.sendsms("SSL Domain Name Alert  :"+domainnme +   " Domane will expired within 3 days date todate:"+todate, "7875505834");
            System.out.println(todate);              
               }
               else {
            	   System.out.println();
               }
       
            
            System.out.print("\n");
        }
			
		}


	private static void Oneweekalertemail() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 18);
		calendar.set(Calendar.MINUTE, 40);
		calendar.set(Calendar.SECOND, 00);
		Sendmail.setRepeating (calendar.getTimeInMillis(), 24*60*60*1000);  //set repeating every 24 hours
		
	}

	private static void TestDate() {
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");		
		 LocalDateTime ldt = LocalDateTime.now();
		 String currentdate = (DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(ldt));
		 System.out.println(currentdate);
		
		 
	}
	 private static Date getTomorrowMorning2PM(){

	        Date date2PM = new java.util.Date(); 
	           date2PM.setHours(TWO_PM); 
	           date2PM.setMinutes(ZERO_MINUTES); 

	           return date2PM;
	      }
	 public static void startTask(){
	        TimerAlert task = new TimerAlert();
	        Timer timer = new Timer();  
	      // timer.schedule(task,getTomorrowMorning2PM(),10*1);// for your case u need to give 1000*60*60*24
	    
	      	 
	 }
	
}