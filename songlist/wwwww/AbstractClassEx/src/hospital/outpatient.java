package hospital;

/**
 * @author 阿賢賢
 */
//extends=is a(後面接繼承的，不一定要宣告成抽象);
//implements=like as(做補充用，interface是一種抽象),這樣叫多重繼承

public class outpatient extends patient implements family, family2 {
    
    public outpatient(String inname, String id, String birthday) {
        //http://hsingjungchen.blogspot.tw/2017/05/java-this-super.html
        super(inname, id);//繼承父親(patient)的建構子patient(String inname, String id)
        System.out.println("This is outpatient birthday:" + birthday);
    }

    @Override
    public void showdetail() {
        System.out.println("This is outpatient name:" + this.getName());
        System.out.println("This is outpatient id:" + this.getID());

    }

    @Override
    public void ShowFamily() {
        System.out.println("Mom's name:" + mothername);
        System.out.println("Dad's name:" + fathername);

    }

    @Override
    public void ShowFamily2() {
        System.out.println("Bro's name:" + brothername);
        System.out.println("Sis1's name:" + sister1name);
        System.out.println("Sis2's name:" + sister2name);

    }
}
