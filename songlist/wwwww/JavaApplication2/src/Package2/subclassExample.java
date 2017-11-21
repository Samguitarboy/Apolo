package Package2;

import Package1.InClassExample;

/**
 * @author pc01
 */
public class subclassExample extends InClassExample {
    public static void main(String[] args) {
        // TODO code application logic here
        subclassExample inclass = new subclassExample();
        System.out.println("[public]:");
        inclass.publicShowMsg();
        
        System.out.println("[private]:");
        //inclass.privateShowMsg();
        
        System.out.println("[package]:");
        //inclass.packageShowMsg();
                
        System.out.println("[protected]:");
        inclass.protectedShowMsg();
    }
}
