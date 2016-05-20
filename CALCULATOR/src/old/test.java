package old;
import java.util.LinkedList;
import java.util.Queue;
//- See more at: http://opensourceforgeeks.blogspot.ru/2013/12/fifo-based-queue-implementation-in-java.html#sthash.wK37GSlw.dpuf
import java.util.Stack;

/**
 * Created by Allex on 17.05.2016.
 */
public class test {






    public static void main(String[] args){
        String str ="(1/2)/(3/4)+4/5-5/6";


        Stack ish=new Stack();
        Queue outt = new LinkedList();
        Stack stt=new Stack();


        for(int i=0;i<str.length();i++){
           ish.push(str.charAt(i));
        }


        while(!ish.isEmpty()){
            char cur=(char)ish.pop();
            if(isNum(cur)){
                outt.add(cur);
            }
            else{
                if(stt.isEmpty()){
                    stt.push(cur);
                }
                else{
                    int pr=getPr(cur);

                    if(pr==0){
                        stt.push(cur);
                    }
                    else if(pr==1){
                        char staked='.';
                        do {
                            staked=(char)stt.pop();
                            if(getPr(staked)!=0)outt.add(staked);
                        } while (staked!=')');
                    }

                }
            }
        }









    }


    public static boolean isNum(char i){
        if(i!='+'&&i!='-'&&i!='*'&&i!='/')return true; else return false;
    }
    public static int getPr(char i){
        switch(i){
            case '(':return 0;
            case ')':return 1;
            case '+':return 2;
            case '-':return 2;
            case '*':return 3;
            case '/':return 3;
            default:return -1;
        }

    }


}
/**
•	Пока есть ещё символы для чтения:
        •	Читаем очередной символ.
        •	Если символ является числом, добавляем его к выходной строке.
        •	Если символ является символом функции, помещаем его в стек.
        •	Если символ является открывающей скобкой, помещаем его в стек.
        •	Если символ является закрывающей скобкой:
        До тех пор, пока верхним элементом стека не станет открывающая скобка, выталкиваем элементы из стека в выходную строку. При этом открывающая скобка удаляется из стека, но в выходную строку не добавляется. Если после этого шага на вершине стека оказывается символ функции, выталкиваем его в выходную строку. Если стек закончился раньше, чем мы встретили открывающую скобку, это означает, что в выражении либо неверно поставлен разделитель, либо не согласованы скобки.
        •	Если символ является оператором о1, тогда:
        1) пока…
        … (если оператор o1 право-ассоциированный) приоритет o1 меньше приоритета оператора, находящегося на вершине стека…
        … (если оператор o1 ассоциированный, либо лево-ассоциированный) приоритет o1 меньше либо равен приоритету оператора, находящегося на вершине стека…
        … выталкиваем верхние элементы стека в выходную строку;
        2) помещаем оператор o1 в стек.
        •	Когда входная строка закончилась, выталкиваем все символы из стека в выходную строку. В стеке должны были остаться только символы операторов; если это не так, значит в выражении не согласованы скобки.
*/