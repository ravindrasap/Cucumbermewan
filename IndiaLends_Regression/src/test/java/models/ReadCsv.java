package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadCsv {
	 	  
	  String csvFile= "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Regression\\src\\test\\CC_DATA.csv";
      String line = "";
      String cvsSplitBy = ",";
      {
      try 
      (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] data = line.split(cvsSplitBy);

              System.out.println(data[0]+ data[1]+data[2]+data[3]+data[4]);

          }

      } catch (IOException e) {
          e.printStackTrace();
      }

  }

}
