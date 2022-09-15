import java.util.ArrayList;

public class Database {
    private String superheroNameText = "Superhero name: ";
    private String superPowerText = "Super power: ";
    private String realNameText = "Your real name: ";
    private String creationYearText = "Creation year: ";
    private String strengthText = "Strength: ";

    private ArrayList<Superhero> superHeroes = new ArrayList();
    /** Vi opretter en array liste i sted for et array så vi ikke behøver ændre størrelse
     * Array listen indeholder superhero (objekter)
    */
    public void createSuperhero(String superheroName, String superpower, int creationYear, String realName, String strength) {
       superHeroes.add(new Superhero(superheroName, superpower, creationYear, realName, strength));
       /** Denne metode tilføjer vi new superhero og vi kalder new
        * så vi kan oprette uden at tilføje det til en variable altså uden
        * eksempel: Superhero superhero = new Superhero();
        */
    }

    public boolean getSuperheroDetailsBySuperHeroName(String searchCriteria, String newLine) { // Det er en public metode der retunere en boolean. Som tager imod 2 strings.
        StringBuilder builder = new StringBuilder(); // Vi opretter en string builder.
        for (Superhero superhero : superHeroes ) { // For hver superhero i superheroes
            if (superhero.getSuperheroName().contains(searchCriteria) == true) { // Hvis superheronavn indeholder searchCriteria = true.
                builder.append(superheroNameText + superhero.getSuperheroName() + newLine); // Builder der tilføler superhero navn tekst og superheltenavn + new line.
                builder.append(superPowerText + superhero.getSuperpower() + newLine); // Builder der tilføjer superpower tekst og hvilken superkræft + new line.
                builder.append(realNameText + superhero.getRealName() + newLine);
                builder.append(creationYearText + superhero.getCreationYear() + newLine);
                builder.append(strengthText + superhero.getStrength() + newLine);
                builder.append(newLine);
                System.out.println(builder.toString()); // Udskriver al teksten til superhero.
                return true; // hvis superhelten findes så retunere vi true.
            } else { // Hvis vi ikke opfylder searchCriteria
                String sryText = " Superhero does not exist, plz try again. ";
                builder.append(sryText + newLine); // builder tilføjer bekalger tekst + new line.
                System.out.println(builder.toString()); // Udskriver en beklager tekst hvis superhelten  ikke findes.
                return false; // Hvis superhelten ikke findes retunere vi false.
            }
        }
    return false; // Hvis ingen superhelte eksistere. Kommer vi aldrig ind i foor loopet
    }


    public boolean getSuperheroDetailsByRealName(String searchCriteria, String newLine) {
        StringBuilder builder = new StringBuilder();
        for (Superhero superhero : superHeroes ) {
            if (superhero.getRealName().contains(searchCriteria) == true) {
                builder.append(superheroNameText + superhero.getSuperheroName() + newLine);
                builder.append(superPowerText + superhero.getSuperpower() + newLine);
                builder.append(realNameText + superhero.getRealName() + newLine);
                builder.append(creationYearText + superhero.getCreationYear() + newLine);
                builder.append(strengthText + superhero.getStrength() + newLine);
                builder.append(newLine);
                System.out.println(builder);
                return true;
            } else {
                String sryText = " Superhero does not exist, plz try again. ";
                builder.append(sryText + newLine);
                System.out.println(builder);
                return false;
            }
        }
    return false;
    }



    public ArrayList<Superhero> getSuperHeroes() {
        return superHeroes;
    }

    public String getSuperheroNameText() {
        return superheroNameText;
    }

    public String getSuperPowerText() {
        return superPowerText;
    }

    public String getRealNameText() {
        return realNameText;
    }

    public String getCreationYearText() {
        return creationYearText;
    }

    public String getStrengthText() {
        return strengthText;
    }

    @Override
    public String toString() {
        return "Database{" +
                "superHeroes=" + superHeroes +
                '}';
        // ToString som udskriver listen superheroes som bruger ToString fra superhero klassen.
    }
}
