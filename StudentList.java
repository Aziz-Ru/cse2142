import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String Reader(){
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
		if(args[0].equals(Constants.ALL)) {
			System.out.println(Constants.LOADING_DATA);
			String line=Reader();
			String students[] = line.split(Constants.SPILT );
			for(String student : students) {
				System.out.println(student);
			}
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].equals(Constants.RANDOM)){
			System.out.println(Constants.LOADING_DATA);
			String line=Reader();
			System.out.println(line);
			String students[] = line.split(Constants.SPILT );
			Random random = new Random();
				int number = random.nextInt(Constants.BOUND);
					System.out.println(students[number]);
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.ADD)){
			System.out.println(Constants.LOADING_DATA);
			String substring = args[0].substring(1);
	        Date date = new Date();
	        String dateType = Constants.DATE_FORMAT;
	        DateFormat dateFormat = new SimpleDateFormat(dateType);
	        String last_date= dateFormat.format(date);
			Writer(substring,last_date);
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.QUERY)){
			System.out.println(Constants.LOADING_DATA);
			String line=Reader();
			//System.out.println(line);
			String students[] = line.split(Constants.SPILT );
			boolean done = false;
			String student_name = args[0].substring(1);

			for(int idx = 0; idx<students.length && !done; idx++) {
				if(students[idx].equals(student_name)) {
					System.out.println(Constants.FOUND_MESSAGE);
						done=true;
				}
			}
			System.out.println(Constants.LOADED_DATA  );
		}
		else if(args[0].contains(Constants.COUNT)){
			System.out.println(Constants.LOADING_DATA);
			String line=Reader();
			char array[] = line.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char ch:array) {
				if (ch == ' ') {
					if (!in_word) {
						count++;
						in_word = true;
					} else {
						in_word = false;
					}
				}
			}	
			System.out.println(count +Constants.WORD_FOUND  + array.length);
			System.out.println(Constants.LOADED_DATA  );
		}
	}
}