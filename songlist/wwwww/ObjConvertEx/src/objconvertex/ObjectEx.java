package objconvertex;

/**
 * @author 阿賢賢
 */
public class ObjectEx {

    private Object ov;
    //private int iv;
    //private double dv;

    public Object getIv() {
        return ov;
    }

    public void setIv(Object ov) {
        this.ov = ov;
    }
/*多型
    public void setValue(int inputV) {
        this.iv = inputV;
    }

    public void setValue(double inputtV) {
        this.dv = inputtV;
    }
*///多型可用object的方式任意轉
}
