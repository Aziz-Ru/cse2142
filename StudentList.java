import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(",");
			for(String student : students) {
				System.out.println(student);
			}
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")){
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			System.out.println(line);
			String students[] = line.split(",");
			Random random = new Random();
				int number = random.nextInt();
					System.out.println(students[number]);
			}
			catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
			String substring = args[0].substring(1);
	        Date date = new Date();
	        String dateType = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateType);
	        String last_date= dateFormat.format(dateFormat);
			bufferedWriter.write(", "+substring+"\nList last updated on "+last_date);
			bufferedWriter.close();
			}
			catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(",");
			boolean done = false;
			String student_name = args[0].substring(1);
			for(int idx = 0; idx<students.length && !done; idx++) {
				if(students[idx].equals(student_name)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			}
			catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")){
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			char array[] = line.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char ch:array) {
				if(ch ==' ')
				{
					if (!in_word) {
						count++;
						in_word =true;
					}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count +" word(s) found " + array.length);
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
	}
}