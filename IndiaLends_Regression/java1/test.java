import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test {
  
	public static void main(String[] args) throws FileNotFoundException {
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
               System.out.println(domainnme);
               System.out.println(todate);
               
            }
            System.out.print("\n");
        }
    }

