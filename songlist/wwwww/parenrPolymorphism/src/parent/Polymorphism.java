package parent;

/**
 * @author 阿賢賢
 */

/*多型<- overloading(建構子有不同形式or method帶有不同引數)也是一種多型*/
public class Polymorphism {

    public static void main(String[] args) {
        Parent parentObj = new Parent();
        child childObj = new child();
        
        parentObj.Show();
        childObj.Show();
        childObj.Show("1234");
        
        parentObj=childObj;
        parentObj.Show();//因為child有覆寫，所以會顯示child
        //parentObj.Show("1234");錯，因為parent裡沒有show(string)
    }
    
}
