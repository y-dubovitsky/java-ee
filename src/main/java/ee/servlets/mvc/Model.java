package ee.servlets.mvc;

import ee.servlets.mvc.beans.Person;

/**
 * This is a model class with one logic method, which return some Person;
 */
public class Model {

    public Person getPerson() {
        Person person = new Person();
        person.setAge(44);
        person.setName("Matthey Visiol II");
        return person;
    }

}
