package old;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Allex on 18.05.2016.
 */

//String str ="(1/2)/(3/4)+4/5-5/6";
public class test3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String input="";
        do{
            System.out.println("");
            System.out.println("");
            System.out.println("print file path or math");
            System.out.println("print 'q' to close");
            input =in.nextLine();
            if(input.equals("q")) break;
                test2.ccalc(input);
        } while(!input.equals("q"));

        //Block bl=test2.ccalc(str);





}

    public boolean is_File(String x){
        File f=new File(x);
        return Files.exists(f.toPath());
    }


    public boolean is_Math(String x){
return false;
    }

}
//  List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
//  for(String line: lines){
//      System.out.println(line);
//  }