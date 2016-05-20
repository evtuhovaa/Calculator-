package old;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Allex on 18.05.2016.
 */
public class test2 {

public static int[][] oper_mas={{5,1,1,1,1,0,1},
                                {2,2,1,1,1,2,1},
                                {2,2,2,1,1,2,1},
                                {0,0,0,0,0,0,1},
                                {0,1,1,1,1,3,1},
                                {0,0,0,0,0,0,0},
                                {4,4,4,0,4,4,1}};

    public static int getID(char a){
        switch (a){
            case '!':return 0;
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
            case '?':return 3;
            case '(':return 4;
            case ')':return 5;
            default: return 6;
        }
    }

    public static int getOperCode(char i,Stack st){
        char tmp=(char)st.pop();
        st.push(tmp);
        return oper_mas[getID(tmp)][getID(i)];
    }
    public static void main(String[] args) {
        String str = "(((?1)*2)/3)+(1*4)/2";


        Stack ish = new Stack();
        ArrayList outt = new ArrayList<>();
        ArrayList<test.Block> output=new ArrayList<test.Block>();// = new LinkedList<Block>();
        Stack stt = new Stack();


        ish.push('!');
        for (int i = 0; i < str.length(); i++) {
            ish.push(str.charAt(str.length() - 1 - i));
        }
        stt.push('!');


        System.out.println(ish);
        System.out.println(stt);


        char cur;
        while (!ish.isEmpty()) {
            cur = (char) ish.pop();
            ish.push(cur);


            int code = getOperCode(cur, stt);

            if (code == 5) {
                break;
            }
            if (code == 0) {
                System.out.print("errrrr");
                break;
            }

            if (code == 1) {
                cur = (char) ish.pop();
                stt.push(cur);
            }

            if (code == 2) {
                cur = (char) stt.pop();
                outt.add(cur);
                output.add(new test.Block(cur));
            }


            if (code == 3) {
                stt.pop();
                ish.pop();
            }


            if (code == 4) {
                int a = 10;
                int sum = 0;
                char c = (char) stt.pop();
                Stack<Integer> num=new Stack<Integer>();
                while (getID(c) == 6) {
                    //sum = sum * a + Integer.parseInt(c + "");
                    num.push(Integer.parseInt(c+""));
                    c = (char) stt.pop();
                    //a = a * 10;
                }

                while(!num.isEmpty()){
                    sum=sum*a+num.pop();

                }

                if (c == '?') sum = sum * (-1);
                else stt.push(c);
                //outt.add('.');
                outt.add(sum);
                output.add(new test.Block(sum));
            }


        }


        System.out.println(ish);
        System.out.println(stt);
        System.out.println(outt);


 test.Mathematics clas=new test.Mathematics(output);
 test.Block result=clas.calc();
System.out.print(result.chis+"/"+result.znam);





    }



    public static test.Block ccalc(String s) {
        String str =s; //"(((?1)*2)/3)+(1*4)/2";


        Stack ish = new Stack();
        ArrayList outt = new ArrayList<>();
        ArrayList<test.Block> output=new ArrayList<test.Block>();// = new LinkedList<Block>();
        Stack stt = new Stack();


        ish.push('!');
        for (int i = 0; i < str.length(); i++) {
            ish.push(str.charAt(str.length() - 1 - i));
        }
        stt.push('!');


        System.out.println(ish);
        System.out.println(stt);


        char cur;
        while (!ish.isEmpty()) {
            cur = (char) ish.pop();
            ish.push(cur);


            int code = getOperCode(cur, stt);

            if (code == 5) {
                break;
            }
            if (code == 0) {
                System.out.print("errrrr");
                break;
            }

            if (code == 1) {
                cur = (char) ish.pop();
                stt.push(cur);
            }

            if (code == 2) {
                cur = (char) stt.pop();
                outt.add(cur);
                output.add(new test.Block(cur));
            }


            if (code == 3) {
                stt.pop();
                ish.pop();
            }


            if (code == 4) {
                int a = 10;
                int sum = 0;
                char c = (char) stt.pop();
                Stack<Integer> num=new Stack<Integer>();
                while (getID(c) == 6) {
                    //sum = sum * a + Integer.parseInt(c + "");
                    num.push(Integer.parseInt(c+""));
                    c = (char) stt.pop();
                    //a = a * 10;
                }

                while(!num.isEmpty()){
                    sum=sum*a+num.pop();

                }

                if (c == '?') sum = sum * (-1);
                else stt.push(c);
                //outt.add('.');
                outt.add(sum);
                output.add(new test.Block(sum));
            }


        }


        System.out.println(ish);
        System.out.println(stt);
        System.out.println(outt);


        test.Mathematics clas=new test.Mathematics(output);
        test.Block result=clas.calc();
        System.out.print(result.chis+"/"+result.znam);
return result;




    }
}








