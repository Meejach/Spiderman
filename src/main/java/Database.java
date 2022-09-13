import java.util.ArrayList;

public class Database {

    private ArrayList<Superhero> superHeroes = new ArrayList();
    /** Vi opretter en array liste i sted for et array så vi ikke behøver ændre størrelse
     * Array llisten indeholder superhero (objekter)
    */
    public void createSuperhero(String superheroName, String superpower, int creationYear, String realName, String strength) {
       superHeroes.add(new Superhero(superheroName, superpower, creationYear, realName, strength));
       /** Denne metode tilføjer vi new superhero og vi kalder new
        * så vi kan oprette uden at tilføje det til en variable altså uden
        * eksempel: Superhero superhero = new Superhero();
        */
    }

    public ArrayList<Superhero> getSuperHeroes() {
        return superHeroes;
    }

    @Override
    public String toString() {
        return "Database{" +
                "superHeroes=" + superHeroes +
                '}';
        // ToString som udskriver listen superheroes som bruger ToString fra superhero klassen.
    }
}
