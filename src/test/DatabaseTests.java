import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class DatabaseTests {

    Database db = new Database();

    @BeforeEach
    public void setUp() {
        Superhero sh = new Superhero("Spiderman", "I'm a spider", 1990, "Peter Parker", "Web");
        db.getSuperHeroes().add(sh);
    }

    @Test
    public void getSuperheroByRealNameTest() {
        Superhero peter_parker = db.getSuperheroByRealName("Peter Parker");
        assertEquals("I'm a spider", peter_parker.getSuperpower());
    }

    @Test
    public void getSuperheroByRealNameFail() {
        Superhero peter_parker = db.getSuperheroByRealName("Hugo");
        assertNull(peter_parker);
    }

    @Test
    public void getSuperheroByRealNameNoSuperheroes() {
        db.getSuperHeroes().remove(0);
        Superhero peter_parker = db.getSuperheroByRealName("Hugo");
        assertNull(peter_parker);
    }

    @Test
    public void getSuperheroByReallNameMore() {
        Superhero sh = new Superhero("Spiderman", "I'm a spider", 1990, "Peter Haka", "Web");
        db.getSuperHeroes().add(sh);
        Superhero peter_parker = db.getSuperheroByRealName("Peter");
        assertEquals("Peter Parker", peter_parker.getRealName());
    }

    @Test
    public void createOneSuperheroTest() {
        assertEquals(1, db.getSuperHeroes().size());
        db.createSuperhero("Spiderman", "I'm a spider", 1990, "Peter Haka", "Web");
        assertEquals(2, db.getSuperHeroes().size());

    }

    @Test
    public void createManySuperheroestest() {
        assertEquals(1, db.getSuperHeroes().size());
        db.createSuperhero("Spiderman", "I'm a spider", 1990, "Peter Haka", "Web");
        db.createSuperhero("Batman", "I'm a bat", 1980, "Bruce Wayne", "Very strong");
        db.createSuperhero("Robin", "I'm a batmans helper", 2000, "Dick Greyson", "Very smart");
        assertEquals(4, db.getSuperHeroes().size());
    }

    @Test
    public void deleteSuperheroTest() {
        assertEquals(1, db.getSuperHeroes().size());
        db.deleteSuperhero(0);
        assertEquals(0, db.getSuperHeroes().size());
    }
}
