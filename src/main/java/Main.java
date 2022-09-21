import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        String menuChoiceFour = "4. Edit superhero";
        String menuChoiceFive = "5. Delete";
        String menuChoiceNine = "9. Exit.";


        Scanner input = new Scanner(System.in); // Laver en scanner fordi vi skal have input fra brugeren!
        Database database = new Database(); // Opretter data objektet som indeholder superhelte.

        while (true) {

            String menuIntroductionText = welcome + newLine + menuChoiceOne + newLine + menuChoiceTwo + newLine + menuChoiceThree + newLine + menuChoiceFour + newLine + menuChoiceFive + newLine + menuChoiceNine;
            System.out.println(menuIntroductionText);
            // Udksrivning tekst til brugeren når man tilgår hovedemenuen.
            int menuChoice = 0;
            try {
                menuChoice = input.nextInt(); // Brugere skal vælge et tal fra menuChoice
            } catch (InputMismatchException ime) {
                input.nextLine();
                System.out.println(menuIntroductionText);
                menuChoice = input.nextInt();
            }

            input.nextLine(); // nextline ellers går nextInt ikke videre til næste linje.

            if (menuChoice == 1) // Hvis menuChoice er 1 sker dette.
            {
                try {
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
                } catch (InputMismatchException ime) {
                    input.nextLine();
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

                }
                database.createSuperhero(superheroName, superpower, creationYear, realName, strength);
                // Kalder databese objektets metode for at oprette en superhelt og den tilføjer til databasen.
            }

            if (menuChoice == 2) {
                StringBuilder builder = new StringBuilder();

                builder.append("List of superheroes ");

                for (Superhero superhero : database.getSuperHeroes()) { // For hver superhero i superheroes
                    builder.append(database.getSuperheroNameText() + superhero.getSuperheroName() + newLine); // Builder der tilføler superhero navn tekst og superheltenavn + new line.
                    builder.append(database.getSuperPowerText() + superhero.getSuperpower() + newLine); // Builder der tilføjer superpower tekst og hvilken superkræft + new line.
                    builder.append(database.getRealNameText() + superhero.getRealName() + newLine); // Builder der tilføjer det rigtige navn nekst og avnet + new line.
                    builder.append(database.getCreationYearText() + superhero.getCreationYear() + newLine); // Builder der tilføjer hvilket år de er skabt tekst og året + new line.
                    builder.append(database.getStrengthText() + superhero.getStrength() + newLine); // Builder der tilføjer skyrke tekst og styrken + new line.
                    builder.append(newLine); // Builder der tilføjer new line.
                }
                System.out.println(builder); // Udskriver al teksten til superhero.

            }

            if (menuChoice == 3) { // Hvis brugeren vælger 3 sker dette.
                boolean superheroFound = false; // Opretter superheroFound = falsk.
                while (superheroFound == false) { // Imens superheroFound = falsk, sker dette.
                    try {
                        System.out.println("A. Search by superhero name." + newLine + "B. Search by real name." + newLine + "Return. Return to main menu");
                        // Udskriver A, B, eller return mulighederne.
                        String choice = input.nextLine(); // Brugere skal vælge et tal fra menuChoice.
                        String searchCriteria = ""; // Opretter searchCriteria.
                        if (choice.equalsIgnoreCase("return")) { // Hvis valg er = return hvor vi ignorere teksten om det er med stort eller småt.
                            superheroFound = true; // setter superheroFound = true. Så stopper loopet.
                        } else { // Ellers sker dette
                            System.out.println("Please enter search criteria: "); // Udskriver teksten til brugrern = Plz enter search criteria.
                            searchCriteria = input.nextLine(); // searchCriteria = Bruger skriver noget.
                        }

                        if (choice.equalsIgnoreCase("A")) { // Hvis valg er = A
                            superheroFound = database.getSuperheroDetailsBySuperHeroName(searchCriteria, newLine);
                            // superheroFound = vi tilgår databasen med getSuperheroDetailsBtSuperHeroName metoden. Som sender to Strings med ind i metoden.
                        }

                        if (choice.equalsIgnoreCase("B")) { // Hvis val er = B
                            superheroFound = database.getSuperheroDetailsByRealName(searchCriteria, newLine);
                            // superheroFound = vi tilgår databasen med getSuperheroDetailsByRealName metoden. Som dender to Strings med ind i metoden.
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("A. Search by superhero name." + newLine + "B. Search by real name." + newLine + "Return. Return to main menu");

                        // Udskriver A, B, eller return mulighederne.
                        String choice = input.nextLine(); // Brugere skal vælge et tal fra menuChoice.
                        String searchCriteria = ""; // Opretter searchCriteria.
                        if (choice.equalsIgnoreCase("return")) { // Hvis valg er = return hvor vi ignorere teksten om det er med stort eller småt.
                            superheroFound = true; // setter superheroFound = true. Så stopper loopet.
                        } else { // Ellers sker dette
                            System.out.println("Please enter search criteria: "); // Udskriver teksten til brugrern = Plz enter search criteria.
                            searchCriteria = input.nextLine(); // searchCriteria = Bruger skriver noget.
                        }

                        if (choice.equalsIgnoreCase("A")) { // Hvis valg er = A
                            superheroFound = database.getSuperheroDetailsBySuperHeroName(searchCriteria, newLine);
                            // superheroFound = vi tilgår databasen med getSuperheroDetailsBtSuperHeroName metoden. Som sender to Strings med ind i metoden.
                        }

                        if (choice.equalsIgnoreCase("B")) { // Hvis val er = B
                            superheroFound = database.getSuperheroDetailsByRealName(searchCriteria, newLine);
                            // superheroFound = vi tilgår databasen med getSuperheroDetailsByRealName metoden. Som dender to Strings med ind i metoden.
                        }

                    }
                }
            }
            if (menuChoice == 4) {
                System.out.println(" Plz enter superhero real name " + newLine);
                String searchCriteria = input.nextLine();


                    Superhero superheroByRealName = database.getSuperheroByRealName(searchCriteria);
                if (superheroByRealName != null){
                System.out.println(" Choose an attribute to edit " + newLine + "A. Superhero name" + newLine + " B. Real name " + newLine +
                        " C. Superpower " + newLine + " D. Creation year " + newLine + " E. Strength" + newLine);
                String choice = input.nextLine(); // Brugere skal vælge et bogstav fra menuChoice.
                if (choice.equalsIgnoreCase("A")) {
                    System.out.println("Plz choose new value");
                    superheroByRealName.setSuperheroName(input.nextLine());
                }
                if (choice.equalsIgnoreCase("B")) {
                    System.out.println("Plz choose new value");
                    superheroByRealName.setRealName(input.nextLine());
                }
                if (choice.equalsIgnoreCase("C")) {
                    System.out.println("Plz choose new value");
                    superheroByRealName.setSuperpower(input.nextLine());
                }
                if (choice.equalsIgnoreCase("D")) {
                    try {
                        System.out.println("Plz choose new value");
                        superheroByRealName.setCreationYear(input.nextInt());
                    } catch (InputMismatchException ime) {
                        System.out.println("Plz choose new value");
                        input.nextLine();
                        superheroByRealName.setCreationYear(input.nextInt());
                    }
                }
                    if (choice.equalsIgnoreCase("E")) {
                        System.out.println("Plz choose new value");
                        superheroByRealName.setStrength(input.nextLine());
                    }
                    System.out.println(database.getSuperheroDetailsBySuperHeroName(superheroByRealName.getSuperheroName(), newLine));
                } else {
                    System.out.println("Sorry your superhero does not exist, plz try again");
                }
            }

            if (menuChoice == 5) {
                int index = -1;
                try {
                    System.out.println("Plz choose an index");
                    index = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException ime) {
                    input.nextLine();
                    System.out.println("Plz choose an index");
                    index = input.nextInt();
                    input.nextLine();
                }
                database.deleteSuperhero(index);
            }
            if (menuChoice == 9) { // Hvis menuChoice er = 9 så exiter vi.
                System.exit(4);
            }
        }
    }
}
