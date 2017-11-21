package hospital;

/**
 * @author 阿賢賢
 */
public abstract class patient {

    private String name;
    private String ID;

    public patient(String inname, String id) {
        this.name = inname;
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public abstract void showdetail();
}
