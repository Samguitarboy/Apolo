package javaapplication1;

/**
 * @author pc01
 */
public class statictry {
    public static String YZUCITY="Tauyuan City"; //一般static都會寫大寫
    String city="TaipeiCity";
    public void statictry(){
    }
    public static void live(){
        statictry st=new statictry();
        System.out.println("[static] I live in "+ st.city);
    }
}
