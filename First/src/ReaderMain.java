import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReaderMain {
    public static void main(String[] args) {
        if(args[0].equals("a")) {
            try {
                File file = new File("/home/aziz/IdeaProjects/First/src/student.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String Line = bufferedReader.readLine();
                System.out.println(Line);
                String Name[] = Line.split(",");
                for (String s : Name) System.out.println(s);
            } catch (Exception e) {
                System.out.println("File Not found");
            }
        }
    }
}
