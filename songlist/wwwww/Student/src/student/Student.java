package student;
import javax.swing.JOptionPane;
/**
 * @author pc01
 */
public class Student {

    public static void main(String[] args) {
        // TODO code application logic here
        studentinfo s1=new studentinfo();
        String name=JOptionPane.showInputDialog("Please input ur name");
        s1.setName(name);
        s1.sayhi();
    }
    
}
