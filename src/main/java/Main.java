import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        String superheroName; // laver atributter
        String superpower;
        int creationYear;
        String realName;
        String strength;
        String welcome = " Welcome to the superhero universe.";
        String newLine = "\n";
        String menuChoiceOne = "1. Create superhero ";
        String menuChoiceTwo = "2. Show superheroes ";
        String menuChoiceThree = "3. Search for superhero ";
        String menuChoiceNine = "9. Exit.";


        Scanner input = new Scanner(System.in); // Laver en scanner fordi vi skal have input fra brugeren!
        Database database = new Database(); // Opretter data objektet som indeholder superhelte.

        while(true) {

            System.out.println(welcome + newLine + menuChoiceOne + newLine + menuChoiceTwo + newLine + menuChoiceThree + newLine + menuChoiceNine);

            int menuChoice = input.nextInt();
            input.nextLine();

            if (menuChoice == 1)
            {

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

            if (menuChoice == 2) {
                StringBuilder builder = new StringBuilder();

                builder.append("List of superheroes ");

                for (Superhero superhero : database.getSuperHeroes() ) {
                    builder.append(database.getSuperheroNameText() + superhero.getSuperheroName() + newLine);
                    builder.append(database.getSuperPowerText() + superhero.getSuperpower() + newLine);
                    builder.append(database.getRealNameText() + superhero.getRealName() + newLine);
                    builder.append(database.getCreationYearText() + superhero.getCreationYear() + newLine);
                    builder.append(database.getStrengthText() + superhero.getStrength() + newLine);
                    builder.append(newLine);
                }
                System.out.println(builder.toString());

            }

            if (menuChoice == 3) {
                boolean superheroFound = false;
                while (superheroFound == false) {
                    System.out.println("A. Search by superhero name." + newLine + "B. Search by real name." + newLine + "Return. Return to main menu");
                    String choice = input.nextLine();
                    String searchCriteria = "";
                    if(choice.equalsIgnoreCase("return")) {
                        superheroFound = true;
                    } else {
                        System.out.println("Please enter search criteria: ");
                        searchCriteria = input.nextLine();
                    }

                    if (choice.equalsIgnoreCase("A")) {
                        superheroFound = database.getSuperheroDetailsBySuperHeroName(searchCriteria, newLine);
                    }

                    if (choice.equalsIgnoreCase("B")) {
                        superheroFound = database.getSuperheroDetailsByRealName(searchCriteria, newLine);
                    }

                }
            }

            if (menuChoice == 9) {
                System.exit(4);
            }
        }
    }
}
