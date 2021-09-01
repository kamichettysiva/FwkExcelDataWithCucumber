package base;

import java.io.*;
import java.util.Scanner;

public class CSVReader {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/test.csv"));
            int lineNumer = 1;
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                    String[] users = line.split(splitBy);    // use comma as separator
                    System.out.println("LineNumber " + lineNumer + line);
                    System.out.println("Users [User Name=" + users[0] + ", Password=" + users[1] + "]");
                lineNumer++;
                //System.out.println(lineNumer);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void readCSVUsingScanner() throws FileNotFoundException {
        String file = "src/test/resources/test.csv";
        Scanner sc = new Scanner(new FileInputStream(file));
        sc.useDelimiter(",");
        while (sc.hasNext()){
            System.out.println(sc.next() + "=======" + sc.nextLine());
        }
        sc.close();
    }



    }

