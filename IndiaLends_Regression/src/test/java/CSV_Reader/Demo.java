package CSV_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	public static void main(String[]args) throws IOException {
		


			  char grade = 'B';
			  switch ( grade )
			  {
			    case 'A':
			      System.out.println( " Excellent ! " );
			      break ;
			    case 'B':
			      System.out.println( " Outstanding ! " );
			      break ;
			    case 'C':
			      System.out.println( " Good ! " );
			      break ;
			    case 'D':
			      System.out.println( " Can do better " );
			      break ;
			    case 'E':
			      System.out.println( " Just passed " );
			      break ;
			    case 'F':
			      System.out.println( " You failed " );
			      break ;
			    default :
			      System.out.println( " Invalid grade " );
			  }
			}
}	
		


