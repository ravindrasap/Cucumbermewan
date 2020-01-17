package models;
import java.io.*; 
import java.util.*; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import com.opencsv.CSVWriter; 
//public class WriteCSV  { 

public class WriteCSV { 
private static final String csv_FILE_PATH 
= "./Resultdata.csv"; 
//String csvFile= "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Regression\\src\\test\\Resultdata.csv";


static String csvFile= "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Regression\\src\\test\\Resultdata.csv";
String line = "";
String cvsSplitBy = ",";

public static void main(String[] args) 
{ 
    addDataToCSV(csvFile); 
} 

public static void addDataToCSV(String output) 
{ 
    // first create file object for file placed at location 
    // specified by filepath 
    File file = new File(output); 
    Scanner sc = new Scanner(System.in); 
    try { 
        // create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 

        // create CSVWriter with ';' as separator 
        CSVWriter writer = new CSVWriter(outputfile, ';', 
                                        CSVWriter.NO_QUOTE_CHARACTER, 
                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                        CSVWriter.DEFAULT_LINE_END); 

        // create a List which contains Data 
        List<String[]> data = new ArrayList<String[]>(); 

        System.out.println("Enter no of rows"); 
        int noOfRow = Integer.parseInt(sc.nextLine()); 
        System.out.println("Enter Data"); 
        for (int i = 0; i < noOfRow; i++) { 
            String row = sc.nextLine(); 
            String[] rowdata = row.split(" "); 
            data.add(rowdata); 
        } 

        WriteCSV.writeAll(data); 
             
      //  writer.writeAll();
         
        // closing writer connection 
        WriteCSV.close(); 
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
    } 
}

private static void close() {
	// TODO Auto-generated method stub
	
}

private static void writeAll(List<String[]> data) {
	// TODO Auto-generated method stub
	
} 
} 