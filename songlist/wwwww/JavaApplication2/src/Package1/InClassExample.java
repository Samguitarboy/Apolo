package Package1;

/**
 * @author pc01
 */
public class InClassExample {

    public static void main(String[] args) {
        // TODO code application logic here
        InClassExample inclass = new InClassExample();
        System.out.println("[public]:");
        inclass.publicShowMsg();
        
        System.out.println("[private]:");
        inclass.privateShowMsg();
        
        System.out.println("[package]:");
        inclass.packageShowMsg();
                
        System.out.println("[protected]:");
        inclass.protectedShowMsg();
    }
    
    public void publicShowMsg(){
    System.out.println("This is public method!");
    }
    private void privateShowMsg(){
    System.out.println("This is private method!");
    }
    void packageShowMsg(){
    System.out.println("This is package method!");
    }
    protected void protectedShowMsg(){
    System.out.println("This is protected method!");
    }
    
    
}
