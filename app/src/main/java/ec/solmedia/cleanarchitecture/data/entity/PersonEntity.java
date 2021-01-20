package ec.solmedia.cleanarchitecture.data.entity;

//JSON
public class PersonEntity {
    //@SerializedName("dni_ci")
    private String dni;
    //@SerializedName("name")
    private String name;
    //@SerializedName("last_name")
    private String lastName;
    //@SerializedName("age")
    private Integer age;
    //@SerializedName("picture_profile")
    private String picture;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
