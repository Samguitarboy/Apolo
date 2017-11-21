/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmethod01;

/**
 *
 * @author Miao
 */
public class HiMsg {
    String name;
    public static String Hey = "I am stupid";
    
    public HiMsg(String str)
    {
        this.name = str;
    }
    
    public void SayHi()
    {
        System.out.println("Hi, Welcome to " + this.name + "'s World!");
    }
    
     public static void SayHi_Static()
    {
        System.out.println("[ Static ]" + HiMsg.Hey );
    }
}
