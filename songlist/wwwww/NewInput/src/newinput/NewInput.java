/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newinput;

import java.util.Scanner;

/**
 *
 * @author Miao
 */
public class NewInput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);//程式會等待User輸入
        
        int inNum1;
        int inNum2;
        int Sum;
        
        System.out.print("Enter Num, 1 : ");
        inNum1 = input.nextInt();
        
        System.out.print("Enter Num, 1 : ");
        inNum2 = input.nextInt();
        
        Sum = inNum1 + inNum2;
        
        System.out.printf("Sum = %d \n", Sum);
        
        //判斷大小
        if (inNum1 > inNum2) 
        {
            System.out.printf(" %d > %d \n", inNum1, inNum2);
        }
        if (inNum1 == inNum2)
        {
            System.out.printf(" %d = %d \n", inNum1, inNum2);
        }
        if (inNum1 < inNum2)
        {
            System.out.printf(" %d < %d \n", inNum1, inNum2);
        }
        if (inNum1 != inNum2)
        {
            System.out.printf(" %d != %d \n", inNum1, inNum2);
        }
        if (inNum1 >= inNum2)
        {
            System.out.printf(" %d >= %d \n", inNum1, inNum2);
        }
        if (inNum1 <= inNum2) 
        {
            System.out.printf(" %d <= %d \n", inNum1, inNum2);
        }

    }
    
}
