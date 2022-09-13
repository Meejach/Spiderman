public class Superhero {

    private String superheroName; // oprette atributter.
    private String superpower;
    private int creationYear;
    private String realName;
    private String strength;

    public Superhero(String superheroName, String superpower, int creationYear, String realName, String strength) {
        this.superheroName = superheroName;
        this.superpower = superpower;
        this.creationYear = creationYear;
        this.realName = realName;
        this.strength = strength;
        // Constructor der tager i mod superhero name
    }

    public Superhero(String superpower, int creationYear, String realName, String strength) {
        this.superpower = superpower;
        this.creationYear = creationYear;
        this.realName = realName;
        this.strength = strength;
        // Constructor der ikke tager i mode superhero name.
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getSuperpower() {
        return superpower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getRealName() {
        return realName;
    }

    public String getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "superheroName='" + superheroName + '\'' +
                ", superpower='" + superpower + '\'' +
                ", creationYear=" + creationYear +
                ", realName='" + realName + '\'' +
                ", strength='" + strength + '\'' +
                '}';
        // ToString metode der returnere atributternes værdier i en string.
    }
}
