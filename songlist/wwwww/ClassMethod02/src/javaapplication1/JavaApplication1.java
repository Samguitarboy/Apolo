package javaapplication1;

import java.time.LocalDateTime;

/**
 * @author pc01
 */
public class JavaApplication1 {

    String name;
    public static void main(String[] args) {

        //1 宣告自己的物件,作裡面的method
        JavaApplication1 app = new JavaApplication1();
        app.Saygoodbye("Eddie");
        
        //2 新加一個class，再宣告它的物件，並作裡面的method
        SayHi yo=new SayHi();
        yo.Go();
        
        //3 新加一個class 建構子帶參數，再宣告它的物件，並作裡面的method
        GG gg = new GG("Goodness");
        gg.Cheer();
        
        //5 JAVA裡可以直接執行的除了object，就是使用static-->static宣告的東西會在執行時就直接載入至記憶體，讓你可以直接用
        //直接調用statictry class裡的static變數
        System.out.println("直接用staic變數:"+statictry.YZUCITY);
        //直接調用statictry class裡的static函式
        statictry.live();
        

    }
    //0 建構子裡加函式
    public JavaApplication1(){
        this.Welcome();
        this.Saygoodbye("Sam");
        
         //4  型別非void
         String datetime = this.getcurrenttime();
         System.out.println(datetime);
    }
    public void Welcome(){
        System.out.println("Hello!");
    }
    public void Saygoodbye(String inname){
        this.name=inname;
        System.out.println("Goodbye, "+this.name);
    }
    String getcurrenttime(){
        String timenow;
        timenow = LocalDateTime.now().toString();
        return timenow;
    }
}
