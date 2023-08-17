import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String Reader(){
		// Reader method Read the 1st Line of student.txt file and return a string
		String line="";
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME)));
			line = bufferedReader.readLine();
		}
		catch (Exception e){
			System.out.println(e);
		}
		return line;
	}
	public static void Writer(String substring,String Date){
		//Writer method write substing and date in student.txt file
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constants.FILE_NAME, true));
			bufferedWriter.write(", "+substring+"\n"+Constants.LAST_UPDATE_MESSAGE+Date);
			bufferedWriter.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		if(args.length>1){
			//step 2
			System.out.println("Number of argument is greater than 1");
		}
		else if(args[0].equals(Constants.ALL)) {
			//when argument equal a then print student name  of student.txt file
			System.out.println(Constants.LOADING_DATA);
			String students[] = Reader().split(Constants.SPILT );
			for(String student : students) {
				System.out.println(student);


		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader s = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String r = s.readLine();
			String i[] = r.split(",");			
			for(String j : i) {
				System.out.println(j);

			}
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].equals(Constants.RANDOM)){
			//when argument equal r then print random student name of student.txt file
			System.out.println(Constants.LOADING_DATA);
			String students[] = Reader().split(Constants.SPILT );
			Random random = new Random();
			int number = random.nextInt(Constants.BOUND);
			System.out.println(students[number]);
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.ADD)){
			//when argument equal +substring then write method write the substring with
			//lat update time random student name of student.txt file
			System.out.println(Constants.LOADING_DATA);
			String substring = args[0].substring(1);

	        String dateType = Constants.DATE_FORMAT;
	        String last_date= new SimpleDateFormat(dateType).format(new Date());
			Writer(substring,last_date);
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.QUERY)){
			//when argument equal ?Student then check student name in student.txt
			System.out.println(Constants.LOADING_DATA);;
			String students[] = Reader().split(Constants.SPILT );
			String student_name = args[0].substring(1);

			for(int idx = 0; idx<students.length; idx++) {
				if(students[idx].equals(student_name)) {
					System.out.println(Constants.FOUND_MESSAGE);
					break;
				}
			}
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.COUNT)){
			
			System.out.println(Constants.LOADING_DATA);
			char array[] = Reader().toCharArray();
			boolean in_word = false;
			int count=0;
			for(char ch:array) {
				if (ch ==Constants.GAP) {
					count++;
				}
			}	
			System.out.println(count/2 +Constants.WORD_FOUND  + array.length);
			System.out.println(Constants.LOADED_DATA  );
		}
		else{
			System.out.println(Constants.INVALID);
		}
	}
}