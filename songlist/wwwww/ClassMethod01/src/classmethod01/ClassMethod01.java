/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmethod01;

import java.time.LocalDateTime;

/**
 *
 * @author Miao
 */
public class ClassMethod01 {

    /**
     * @param args the command line arguments
     */
    String name;

    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        //ClassMethod01 test = new ClassMethod01();
        
        //HiMsg.SayHi_Static();
        
        System.out .println(HiMsg.Hey);
    }

    public ClassMethod01() 
    {
        //this.Welcome();
        //this.Introduction("Hey");

        //step 01
        salud saludObj = new salud();
        saludObj.SayHi();

        //step 02
        HiMsg app = new HiMsg("Miao");
        app.SayHi();

        //step 03
        String DateString = this.getNowDateTimeString();
        System.out.println(DateString);
    }

    public String getNowDateTimeString() {
        String dateString;
        dateString = LocalDateTime.now().toString();
        return dateString;
    }

    public void Welcome()
    {
        System.out.println("Hello!");
    }

    public void Introduction(String str) 
    {
        this.name = str;
        System.out.println("this " + this.name);
    }

}
