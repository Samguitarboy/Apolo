package Package1;

/**
 * @author pc01
 */
public class packageExample {
     public static void main(String[] args) {
        // TODO code application logic here
        InClassExample inclass = new InClassExample();
        System.out.println("[public]:");
        inclass.publicShowMsg();
        
        System.out.println("[private]:");
        //inclass.privateShowMsg();
        
        System.out.println("[package]:");
        inclass.packageShowMsg();
                
        System.out.println("[protected]:");
        inclass.protectedShowMsg();
    }
}
