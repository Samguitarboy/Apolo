/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *抽象繼承
 * @author 阿賢賢
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        outpatient op = new outpatient("Sam","1234","2017-11-07");
        op.showdetail();
        op.ShowFamily();
        op.ShowFamily2();
    }
    
}
