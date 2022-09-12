import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        String superheroName; // laver atributter
        String superpower;
        int creationYear;
        String realName;
        String strength;

        Scanner input = new Scanner(System.in); // Laver en scanner fordi vi skal have input fra brugeren!
        Database database = new Database(); // Opretter data objektet som indeholder superhelte.
        for (int i = 0; i < 5; i++) { // loop der køre indtil i er 5.

        System.out.println(" What is your superhero name? "); // Udskriver tekst til bruger
        superheroName = input.nextLine(); // Tager i mod brugernes indput

        System.out.println(" What is your superpower? "); // Udskriver tekst til brugerne
        superpower = input.nextLine(); // Tager imod brugerens indput
        System.out.println(" What year were you created in? "); // Udskriver tekst til brugeren
        creationYear = input.nextInt(); // Tager imod brugerens indput.
        input.nextLine(); //Ellers går "nextInt" ikke videre til næste linje

        System.out.println(" What is your real name? "); // Udskriver tekst til brugeren.
        realName = input.nextLine(); // Tager imod brugerens indput.

        System.out.println(" What is your strength ? "); // Udskriver tekst til brugeren.
        strength = input.nextLine(); // Tager imod brugerens indput

        database.createSuperhero(superheroName, superpower, creationYear, realName, strength);
        // Kalder databese objektets metode for at oprette en superhelt og den tilføjer til databasen.
        }

        System.out.println(database); // Bruger to-String metoder til at skrive objekternes værdier ud.
    }
}
