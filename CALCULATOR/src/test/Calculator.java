package test;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Allex on 18.05.2016.
 */



public class Calculator {
    public static void main(String[] args){
        if(args.length!=0){
            String cur=args[0];
            if(isFile(cur)){
                List<String> outt = new ArrayList<String>();
                List<String> mas=new ArrayList<String>();
                try{
                    Scanner in = new Scanner(new File(cur));
                    while (in.hasNextLine())
                        mas.add(in.nextLine());
                    in.close();
                }catch(Exception e){}
                for (String curent:mas) {
                   outt.add("_\n\n\n_");outt.add( try_to_calc_usual(curent));
                }
                FileWriter writeFile = null;
                try {
                    File file = new File(System.getProperty("user.dir")+File.separatorChar+"result.txt");
                    if(!file.exists())file.createNewFile();
                    writeFile = new FileWriter(file);
                    for (String out_string:outt) {
                        writeFile.append(out_string);
                    }
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(writeFile != null) {
                        try {
                            writeFile.close();
                        } catch (IOException e) {
                        }
                    }
                }

            }
        }
        else{
            Scanner in = new Scanner(System.in);
            String input="";
            while(!input.equals("q")){
                System.out.println("\n\n\nВыбран обычный режим");
                System.out.println("Введи:\nстроку выражения или  \n'q' для выхода ");
                input=in.nextLine();
                if(!input.equals("q")){
                    System.out.println(try_to_calc_usual(input));
                }
            }
        }
    }
public void old_main(){
    Scanner in = new Scanner(System.in);
    String input="";
    while(!input.equals("close")){
        System.out.println("Выбери режим работы: \n 1-обычный\n 2-расширенный\n close - закрыть программу");
        input=in.nextLine();
        switch(input){
            case "1":{
                one_cycle_of_usual_work();
                break;
            }

            case "2":{
                one_cycle_of_special_work();
                break;
            }
            case "close":System.out.println("Программа сейчас закроется"); break;
            default:
                System.out.println("Ошибка в команде выбора режима");
                break;
        }
    }
}
    public static void one_cycle_of_usual_work(){

        Scanner in = new Scanner(System.in);
        String input="";
        while(!input.equals("q")){
            System.out.println("\n\n\nВыбран обычный режим");
            System.out.println("Введи:\nстроку выражения или \nпуть к файлу или \n'q' для выхода в меню выбора режима");
            input=in.nextLine();
            if(!input.equals("q")){
            if(isFile(input)){
                List<String> mas=getLines(input);
                for (String curent:mas) {
                    try_to_calc_usual(input);
                }
            }
            else try_to_calc_usual(input);
            }
        }
    }

    public static void one_cycle_of_special_work(){
        Scanner in = new Scanner(System.in);
        String input="";
        while(!input.equals("q")){
            System.out.println("Выбран спец режим");
            System.out.println("Введи:\nстроку выражения или \nпуть к файлу или \n'q' для выхода в меню выбора режима");
            input=in.nextLine();
            if(!input.equals("q")){
            if(isFile(input)){
                List<String> mas=getLines(input);
                for (String curent:mas) {
                    try_to_calc_special(input);
                }
            }
            else try_to_calc_special(input);
        }
    }}


    public static boolean isFile(String inp){
        try{File f=new File(inp);
            return Files.exists(f.toPath());}catch(Exception ex){return false;}

    }

    public static List<String> getLines(String inp){
        File f= new File(inp);
        try{
            return Files.readAllLines(Paths.get(inp), StandardCharsets.UTF_8);
        }catch(Exception e){}
        finally{
            return null;
        }

    }

    public static boolean is_usual_string(String inp){
        return RegClass.checkWithRegExp(inp);
    }

    public static String check_negative(String inp){
        return inp;
    }

    public static String try_to_calc_usual(String str){
    if(is_usual_string(str)){
       return PolskaClass.Calc(str);
    }
        return "eror";
}

    public static void try_to_calc_special(String str){
        str=check_negative(str);
        PolskaClass.Calc(str);
    }
}
