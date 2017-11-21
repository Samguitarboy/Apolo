package parent;

/**
 *覆寫: http://peimei0808.pixnet.net/blog/post/129480731-%5Bjava%5D-java%E4%B8%AD%E5%87%BD%E6%95%B8%E3%80%8C%E8%A6%86%E5%AF%AB%28override%29%E3%80%8D%E4%B9%8B%E4%BB%8B%E7%B4%B9
 */
public class child extends Parent {

    @Override //當繼承時 child用到和parent一樣的函式，但有另外用途時,就要用@override
    void Show() {
        System.out.println("This is child Class");
    }

    void Show(String str) {
        System.out.println(str);
    }
}
