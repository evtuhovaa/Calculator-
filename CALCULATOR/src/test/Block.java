package test;

/**
 * Created by Allex on 18.05.2016.
 */
public class Block {

    public Block(char i){
        this.isNum=false;
        this.funk=i;
    }

    public Block(int a){
        this.isNum=true;
        this.isPos=(a>=0);
        this.chis=a;
        this.znam=1;
    }


    public Block(int a,int b){
        this.isNum=true;
        this.isPos=(a>=0);
        this.chis=a;
        this.znam=b;
        this.esierer();
    }
    public  void esierer(){
        int x = chis;
        int px=Math.abs(x);
        int y=znam;
        int nod=NOKNOD.gcd(px,y);
        chis=chis/nod;znam=znam/nod;
    }
    int chis;
    int znam;
    boolean isNum;
    boolean isPos;
    char funk;
    String chisl;
}
