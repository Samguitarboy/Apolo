/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1031511_hw1;

import java.util.Scanner;

/**
 * @BMI計算機
 * @author 阿賢賢
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float height, weight, BMI;

        Scanner input = new Scanner(System.in);
        System.out.print(" 身高(cm) : ");
        height = input.nextFloat();
        System.out.print(" 體重(kg) : ");
        weight = input.nextFloat();

        BMI = (weight / ((height / 100) * (height / 100)));
        System.out.printf(" 您的 BMI : %f \n", BMI);
        if (BMI < 18.5) {
            System.out.println(" 體重過輕");
        } else if (BMI >= 18.5 && BMI < 24) {
            System.out.println(" 健康體位");
        } else if (BMI >= 24 && BMI < 27) {
            System.out.println(" 過重");
        } else if (BMI >= 27 && BMI < 30) {
            System.out.println(" 輕度肥胖");
        } else if (BMI >= 30 && BMI < 35) {
            System.out.println(" 中度肥胖");
        } else {
            System.out.println(" 重度肥胖");
        }
    }

}
