import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVTOHTML {

    public static void main(String[] args) {
        try {
            System.out.println("<html>");
            
        System.out.println("<head><style>");
        System.out.println("table { border-collapse: collapse;margin: 40px 30px;font-size: 1em;");
        System.out.println("font-family: sans-serif; min-width: 400px box-shadow: 0 0 20px #00000040;");
        System.out.println("}");
        System.out.println("th, td {padding: 12px 15px;}");
        System.out.println("tr { border-bottom: 1px solid #dddddd;}");
        System.out.println("tr:nth-of-type(even) {  background-color: #f3f3f3;}");
        System.out.println("tr:last-of-type {border-bottom: none;}");
        System.out.println("</style></head>");
        
        System.out.println("<body><p>");
            List<String[]> list = readAll(new File("students.csv"));
        System.out.println("<table>");
        for(int i=0;i<list.size();i++){
        System.out.print("<tr>");
        String arr[] = list.get(i);
        for(int j=0;j<arr.length;j++){
            System.out.print("<td>"+arr[j]+"</td>");
        }
        System.out.println("</tr>");
        }
        System.out.println("</table>");
            System.out.println("</p></body></html>");
        
        } catch(Exception e) {
            System.out.println("<html><body><pre>");
            System.out.println("Ooops, something went wrong. There was an exception in the Java program:");
            e.printStackTrace(System.out);
            System.out.println("</pre></body></html>");
        }
    }

    public static List<String[]> readAll(File csvFile) throws Exception {
        List<String[]> output = new ArrayList<>();
        try (Scanner fin = new Scanner(csvFile)) {
            while(fin.hasNextLine()) {
                output.add(fin.nextLine().split(","));
            }    
        }
        return output;
    }    

}

