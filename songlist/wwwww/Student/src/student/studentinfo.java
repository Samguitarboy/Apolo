package student;
import javax.swing.JOptionPane;
/**
 * @author pc01
 */
public class studentinfo {
    private String name;
    private String gender;
    private String address;
    private String id;
    private int age;
    private float weight;
    private float height;

    //construtor
    public void stustudentinfo() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

  
    public void sayhi(){
        JOptionPane.showMessageDialog(null,"Hi,I'm "+this.name,"Sayhi",JOptionPane.INFORMATION_MESSAGE);
    }
}
