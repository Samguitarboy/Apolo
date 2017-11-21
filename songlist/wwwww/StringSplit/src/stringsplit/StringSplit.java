package stringsplit;

/**
 * @author 阿賢賢
 */
public class StringSplit {

    public static void main(String[] args) {
        System.out.println("abc");
        String cde = "cde";
        System.out.println("abc" + cde);
        String c = cde.substring(2, 3);
        System.out.println(c);
        String d = cde.substring(1, 2);
        System.out.println(d);
        System.out.println("cde.substring(0): " + cde.substring(0));
        System.out.println("cde.substring(1): " + cde.substring(1));
        System.out.println("cde.substring(0,1): " + cde.substring(0, 1));
        System.out.println("cde.substring(0,2): " + cde.substring(0, 2));
        System.out.println("cde.substring(2,3): " + cde.substring(2, 3));
        StringSplit app = new StringSplit();
        app.splitDemo2();
    }

    public void splitDemo() {
        String str = "abc,123,qwe,456,000";
        System.out.println(str);

        String[] substr = str.split((","));
        System.out.println("Substr number:" + substr.length);

        for (String subs : substr) {
            System.out.println(subs);
        }
        for (int i = 0; i < substr.length; i++) {
            System.out.println(substr[i]);
        }
    }
    public void splitDemo2() {/*正規*/
        String str = "abc=123,qwe_456:000";
        System.out.println(str);

        String[] substr = str.split("[=|_|:|,]");
        System.out.println("Substr number:" + substr.length);

        for (String subs : substr) {
            System.out.println(subs);
        }
    }
}
