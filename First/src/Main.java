import java.io.*;
import java.text.*;
import java.util.*;

public class Main {
    public static String[] reader(){
        String words[]={};
        try {
            FileReader file=new FileReader("/home/aziz/cse2142/students.txt");
            BufferedReader bufferedReader=new BufferedReader(file);
            String line=bufferedReader.readLine();
            words= line.split(",");
            file.close();
        } catch (Exception e){}
        return words;
    }
    public static void main(String[] args)
    {
        if(args[0].equals("a")) {
            String words[]=reader();
            for(String s:words) System.out.println(s);
        }
        else if(args[0].equals("r"))
        {
            String words[]=reader();
            Random random=new Random();
            int x=random.nextInt(4);
            System.out.println(words[x]);
        }
        else if(args[0].contains("+")){
            try {
                BufferedWriter s = new BufferedWriter(
                        new FileWriter("/home/aziz/cse2142/students.txt", true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(d);
                s.write(", "+t+"\nList last updated on "+fd);
                s.close();
            } catch (Exception e){}

            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("?"))
        {
            System.out.println("Loading data ...");
            try {
          FileReader fr=new FileReader("D:\\testout.txt");      String words[]=reader();
                boolean done = false;
                String t = args[0].substring(1);
                for(int idx = 0; idx<words.length && !done; idx++) {
                    if(words[idx].equals(t)) {
                        System.out.println("We found it!");
                    }
                }
            } catch (Exception e){}
            System.out.println("Data Loaded.");
        }
        else if(args[0].contains("c"))
        {
            System.out.println("Loading data ...");
            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String D = s.readLine();
                char a[] = D.toCharArray();
                boolean in_word = false;
                int count=0;
                for(char c:a) {
                    if(c ==' ')
                    {
                        if (!in_word) {	count++; in_word =true;	}
                        else { in_word=false;}
                    }
                }
                System.out.println(count +" word(s) found " + a.length);
            } catch (Exception e){}
            System.out.println("Data Loaded.");
        }
    }
}