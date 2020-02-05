package ee.jsp.beans;

/**
 * This is a simple bean;
 */
public class Person {

    private Name name;
    private int id;
    private long longevity;


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLongevity(long longevity) {
        this.longevity = longevity;
    }

    public long getLongevity() {
        return longevity;
    }
}

