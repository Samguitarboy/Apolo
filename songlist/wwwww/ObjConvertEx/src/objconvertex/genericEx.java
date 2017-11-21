package objconvertex;

//泛型，當我不知道丟進來的會是甚麼的時候
public class genericEx<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }
    
}
