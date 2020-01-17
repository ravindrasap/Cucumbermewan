package SSLAlert;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;


public class TimerAlert extends TimerTask {
    private final static long ONCE_PER_DAY = 1000*60*60*24;

    //private final static int ONE_DAY = 1;
    private final static int TWO_AM = 2;
    private final static int ZERO_MINUTES = 0;


    @Override
    public void run() {
        long currennTime = System.currentTimeMillis();
        long stopTime = currennTime + 2000;//provide the 2hrs time it should execute 1000*60*60*2
          while(stopTime != System.currentTimeMillis()){
              // Do your Job Here
        	//  SSL_Alert = new SSL_Alert();
        	  
            System.out.println("Start Job"+stopTime);
            System.out.println("End Job"+System.currentTimeMillis());
          }
    }
    private static Date getTomorrowMorning2AM(){

        Date date2am = new java.util.Date(); 
           date2am.setHours(TWO_AM); 
           date2am.setMinutes(ZERO_MINUTES); 

           return date2am;
      }
    //call this method from your servlet init method
    public static void startTask(){
        TimerAlert task = new TimerAlert();
        Timer timer = new Timer();  
        timer.schedule(task,getTomorrowMorning2AM(),1000*10);// for your case u need to give 1000*60*60*24
    }
    public static void main(String args[]){
        startTask();

    }

}