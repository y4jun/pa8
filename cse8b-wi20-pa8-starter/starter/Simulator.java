import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Simulator {

    // Used if user selects bulbasaur as starter
    private static final int BULBASAUR = 2;

    // Used to parse the level of a Pokemon
    private static final int LEVEL_INDEX = 2;

    // Number of required arguments
    private static final int REQUIRED_ARGS = 2;

    // Used to split pokemon file / user input
    private static final String SEPARATOR = ",";
    private static final String PROMPT_SEP = " ";

    // Used to index through user arguments
    private static final int BOX_INDEX = 1;
    private static final int POS_INDEX = 2;
    private static final int TO_BOX_INDEX = 3;
    private static final int TO_POS_INDEX = 4;

    // Different choices user can make 
    private static final String OPTION_0 = "0";
    private static final String OPTION_1 = "1";
    private static final String OPTION_2 = "2";

    private static final String USER_PROMPT = "> ";

    private static final String USAGE_PROMPT =
        "\nUsage: java Simulator [0|1|2] [filename]\n" +
        "0 - Charmander, 1 - Squirtle, 2 - Bulbasaur\n\n";

    private static final String MAIN_PROMPT =
        "\nWhat would you like to do?\n" + 
        "[0] - Go into the wild!\n" +
        "[1] - View your PC!\n\n";

    private static final String PC_PROMPT =
        "\nCurrently viewing someone's PC\n" +
        "[0] b           - View box b (specify a number)\n" +
        "[1] b1 p1 b2 p2 - Move Pokemon at box b1, pos p1 to box b2, p2\n" +
        "[2] b p         - Release Pokemon at box b, pos p\n\n";

    private static final String WILD_PROMPT =
        "\nYou have encountered a level %d %s!\n" +
        "[0] - Catch\n" + 
        "[1] - Run\n\n";
    
    private static final String CAUGHT_PROMPT =
        "\nSuccessfully caught %s!\n";

    private static final String RUN_PROMPT =
        "\nPhew... ran away!\n";

    private static final String BATTLE_INTRO =
        "\nBattling against your rival!\n" +
        "Your rival sent out %s.\n" +
        "Go! %s!\n" +
        "--------------------------------------\n";

    private static final String BATTLE_MAIN =
        "Your rival has dealt %d damage!\n" +
        "You dealt %d damage!\n\n";

    private static final String BATTLE_WIN =
        "You won!\n";

    private static final String BATTLE_LOSE =
        "You lost! Smell you later!\n";

    private static final String EMPTY_WILD =
        "No more pokemon in the wild!\n";

    private static final String SUCCESSFUL_MOVE =
        "Successful move!\n";

    private static final String SUCCESSFUL_RELEASE =
        "Successful release!\n";

    private static final String UNRECOGNIZED_PROMPT =
        "Unrecognized command. Please try again.\n\n";

    private static final String FILE_NOT_FOUND =
        "File: %s could not be found!\n\n";

    // One storage, one scanner (reinitialize scanner as necessary)
    private static PokemonStorageSystem<Pokemon> storage;
    private static Scanner scanner;

    private static void handleBattle(Pokemon starter, Pokemon rival) {
        // Initial battle text
        System.out.printf(BATTLE_INTRO, rival.getName(), starter.getName());

        /** TODO Implement rival battle logic */
        // Calculate damage done from each pokemon

        // Use System.out.printf with BATTLE_MAIN as format string

        // Battle logic -- you win if your damage > rival damage
        // System.out.printf BATTLE_WIN if you win
        // else BATTLE_LOSE
    }

    private static void handleWild(Pokemon wild) {
        // Use the wild pokemon that was passed in
        System.out.printf(WILD_PROMPT, wild.getLevel(), wild.getName());

        // Parse user's next decision
        String line;
        
        boolean invalid = true;

        try {
            // Keep prompting user until a valid action has been made
            while(invalid) {
                System.out.print(USER_PROMPT);
                line = scanner.nextLine().toUpperCase().trim();

                switch(line) {
                    case OPTION_0:
                        invalid = false;
                        storage.deposit(wild);
                        System.out.printf(CAUGHT_PROMPT, wild.getName());
                        break;
                    case OPTION_1:
                        invalid = false;
                        System.out.printf(RUN_PROMPT);
                        break;
                    default:
                        System.out.printf(UNRECOGNIZED_PROMPT);
                        break;
                }
            }
        }
        /** TODO Add catch statement here. No `Exception e` */ 
    }
    
    private static void handlePC() {
        System.out.printf(PC_PROMPT);

        String line;
        String[] splitLine;
       
        // Keep looping until we have a valid input
        boolean invalid = true;

        try {
            while(invalid) {
                System.out.print(USER_PROMPT);
                line = scanner.nextLine().trim();
                splitLine = line.split(PROMPT_SEP);

                // Check to ensure number of required args is correct
                // If so, then parse accordingly
                // Assumes that inputs are numbers; Not handling invalid cases
                switch(splitLine[0].toUpperCase()) {
                    case OPTION_0: {
                        if(/** TODO Check for right number of args */) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }
                        
                        invalid = false;
                        /** TODO Pase argument and pass in getBox */
                        

                        /** TODO System.out.printf output of getBox */

                        break;
                    }
                    case OPTION_1: {
                        if(/** TODO Check for right number of args */) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }

                        invalid = false;
                        /** TODO Parse arguments and pass into move */

                        System.out.printf(SUCCESSFUL_MOVE);
                        break;
                    }
                    case OPTION_2: {
                        if(/** TODO Check for right number of args */) {
                            System.out.printf(UNRECOGNIZED_PROMPT);
                            break;
                        }

                        invalid = false;
                        /** TODO Parse arguments and pass into release */


                        System.out.printf(SUCCESSFUL_RELEASE);
                        break;
                    }
                    default:
                        System.out.printf(UNRECOGNIZED_PROMPT);
                        break;
                }
            }
        }
        /** TODO Add catch statement */
    }


    public static void main(String[] args) {

        if(/** TODO Make sure we have right number of args */) {
            System.out.printf(USAGE_PROMPT);
            return;
        }

        /** TODO Initialize global pokemon storage */

        // Choose your starter pokemon
        int choice = Integer.parseInt(args[0]);
        Pokemon starter = null;
        Pokemon rival = null;

        /** TODO Initialize the starter and rival variables accordingly */

        storage.setPartyMember(starter);

        /** TODO Start battle against the opposing rival pokemon */

        // Retrieve the filename of all the Pokemon that can be attainable
        List<Pokemon> allPokemon = /** TODO */ 
        if(allPokemon == null) {
            return;
        }

        // Used to index through allPokemon
        int currIndex = 0;

        // Interactive mode
        System.out.printf(MAIN_PROMPT);
        System.out.print(USER_PROMPT);

        scanner = new Scanner(System.in);
        String line;

        // Keep looping until ctrl+D
        while(scanner.hasNextLine()) {
            // Decide whether to go into the wild or view PC
            line = scanner.nextLine().toUpperCase().trim();

            switch(line) {
                case OPTION_0:
                    if( /** TODO Handle case for no more wild pokemon */) {
                        System.out.printf(EMPTY_WILD);
                    } else {
                        /** TODO Call on handleWild */
                    }
                    break;
                case OPTION_1:
                    /** TODO Call on handlePC */
                    break;
                default:
                    System.out.printf(UNRECOGNIZED_PROMPT);
                    break;
            }

            System.out.printf(MAIN_PROMPT);
            System.out.print(USER_PROMPT);
        }
    }
}
