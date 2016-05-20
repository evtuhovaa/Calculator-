package test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Allex on 18.05.2016.
 */
public class Mathematics {
    public static Block sumurise(Block x,Block y){
        x.esierer();
        y.esierer();
        if(x.znam==y.znam){return new Block((x.chis+y.chis),x.znam);}
        else
        {
            int ob=x.znam*y.znam;
            int a=x.chis*y.znam;
            int b=y.chis*x.znam;
            int ab=a+b;
            return new Block(ab,ob);
        }
    }
    public static Block decrementaise(Block x,Block y){
        x.esierer();
        y.esierer();
        if(x.znam==y.znam){return new Block((x.chis-y.chis),x.znam);}
        else
        {
            int ob=x.znam*y.znam;
            int a=x.chis*y.znam;
            int b=y.chis*x.znam;
            int ab=a-b;
            return new Block(ab,ob);
        }
    }
    public static Block divide(Block x,Block y){
        x.esierer();
        y.esierer();
        int chis=x.chis*y.znam;
        int znam=x.znam*y.chis;

        if(chis<0&&znam<0){chis*=-1;znam*=-1;}
        if(znam<0){chis*=-1;znam*=-1;}

        return new Block(chis,znam);
    }
    public static Block multipile(Block x,Block y){
        x.esierer();
        y.esierer();

        int chis=x.chis*y.chis;
        int znam=x.znam*y.znam;

        if(chis<0&&znam<0){chis*=-1;znam*=-1;}
        if(znam<0){chis*=-1;znam*=-1;}

        return new Block(chis,znam);
    }
    Stack<Block> ish;
    public Mathematics(ArrayList<Block> lst){
        ish=new Stack<Block>();
        for (int i=lst.size()-1;i>=0;i--){
            ish.push(lst.get(i));
        }
    }

    public static Block calc_one(Block x,Block y,char funk){
        switch (funk){
            case '+': return sumurise(x,y);
            case '-':return decrementaise(x,y);
            case '*':return multipile(x,y);
            case '/':return divide(x,y);
            default:return null;
        }
    }

    public Block calc(){

        boolean work=true;
        Stack<Block> stt=new Stack<Block>();
        while(!ish.isEmpty()){
            Block cur=ish.pop();
            if(cur.isNum){stt.push(cur);}
            else
            {
                Block y=stt.pop();
                Block x=stt.pop();
               stt.push(calc_one(x,y,cur.funk));
            }
        }


        return stt.pop();

    }

}


