package objconvertex;

/**
 * @author 阿賢賢
 */
public class ObjConvertEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //double doubleValue1 = 5.65;
        //Double doubleValue2 = 6.65;//Double原生繼承Object Class
        //int intValue = 49;
        String StrValue = "     76   ";
        int weight = Integer.parseInt(StrValue.trim());
        double weight_double = Double.parseDouble(StrValue);

        int v = (int) weight_double;

        System.out.println("[" + StrValue + "]");
        System.out.println("[" + StrValue.trim() + "]");
        System.out.println(weight);
        System.out.println(weight_double);
        System.out.println(v);
        /*Object
        ObjectEx obj = new ObjectEx();

        obj.setIv(1234);

        double dv = Double.parseDouble(obj.getIv().toString());
        System.out.println(dv);
         */
        genericEx<Integer> genapp1 = new genericEx<Integer>();
        genericEx<Boolean> genapp2 = new genericEx<Boolean>();
        genericEx<Double> genapp3 = new genericEx<Double>();

        genapp1.setFoo(1234);
        System.out.println(genapp1.getFoo());
        genapp2.setFoo(true);
        System.out.println(genapp2.getFoo());
        System.out.println(genapp2.getFoo().getClass());
        genapp3.setFoo(1234.23325);
        System.out.println(genapp3.getFoo());
    }

}
