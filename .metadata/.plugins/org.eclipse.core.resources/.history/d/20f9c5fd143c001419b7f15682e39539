import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * <h1>TextBuddy</h1> TextBuddy application that performs functions as described
 * in CE1.
 * <p>
 * Assupmtions: -> If any exceptions/errors are encountered, default action is
 * to quit program -> If file already exist, file content must only contain text
 * 
 * Note: -> For regression testing, use TestInput.txt order for the expected
 * output to reflect the proper strings. Regression testing commands used:
 * 
 * java TextBuddy TestFile.txt < testinput.txt > output.txt
 * fc output.txt expected.txt
 *
 * 
 * @author Cheah Kit Weng, A0059806W
 *
 */
public class TextBuddy {
    // Messsages required by TextBuddy
    public static final String ERROR_INVALID_ARGUMENTS = "Incorrect number of arugments found!";
    public static final String ERROR_FILENAME_INCORRECT = "File is invalid!";
    public static final String ERROR_WHILE_SAVING = "Error encountered while saving content to file!";
    public static final String ERROR_ILLEGAL_COMMAND = "Invalid command detected! Acceptable commands are:";
    public static final String ERROR_UNKNOWN = "Unknown error encountered! TextBuddy is exiting...";

    public static final String PROMPT_COMMAND = "command: ";

    // Current file that is being accessed
    public static String currentFilename = "";
    public static ArrayList<String> fileContent = null;

    // These are the possible command types
    enum COMMAND_TYPE {
        ADD_LINE, DISPLAY, DELETE, CLEAR, EXIT, INVALID
    };

    /**
     * These are the possible command inputs from console
     * 
     * These are mapped to the COMMAND_TYPES in the following:
     * COMMAND_FROM_CONSOLE[0] -> ADD_LINE 
     * COMMAND_FROM_CONSOLE[1] -> DISPLAY
     * COMMAND_FROM_CONSOLE[2] -> DELETE 
     * COMMAND_FROM_CONSOLE[3] -> CLEAR
     * COMMAND_FROM_CONSOLE[4] -> EXIT
     */
    private static String[] COMMAND_FROM_CONSOLE = { "add", "display",
            "delete", "clear", "exit" };

    // Variable to hold keyboard input reader
    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    /**
     * Main Method
     * 
     * @param args
     *            Command-line arguments
     */
    public static void main(String[] args) {
        checkArguments(args);
        currentFilename = args[0];
        readFile(currentFilename);
        displayGreeting();
        processUserInput();

    }

    /**
     * Method to check if arguments are valid
     * 
     * @param args
     *            Array to be checked
     */
    private static void checkArguments(String[] args) {
        if (args.length < 1) {
            printAndExitApplication(ERROR_INVALID_ARGUMENTS);
        }

        if (!isValidFile(args[0])) {
            printAndExitApplication(ERROR_FILENAME_INCORRECT);
        }

    }

    /**
     * Method to check that the filename is valid. Currently, a valid file is
     * just the file path is valid. Expandable to include file extension checks
     * 
     * @param filename
     *            Filename to be checked
     * @return True if filename is valid; False otherwise
     */
    private static boolean isValidFile(String filename) {
        if (isValidDirectory(filename)) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if directory is valid (if any). This method is here in
     * case the declared file path is invalid.
     * 
     * @param filename
     *            File to be checked
     * @return True if directory is valid; False otherwise
     */
    private static boolean isValidDirectory(String filename) {
        File file = new File(filename);
        File parentDirectory = file.getParentFile();

        if (parentDirectory != null && !parentDirectory.isDirectory()) {
            return false;
        }

        return true;
    }

    /**
     * Method to read file content(if any) and initalize file content variable
     * 
     * @param filename
     *            File to be accessed
     */
    private static void readFile(String filename) {
        File file = new File(filename);
        fileContent = new ArrayList<String>();

        // Checks if file exist, load content into application
        if (file.isFile()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line = br.readLine();
                while (line != null) {
                    fileContent.add(line);
                    line = br.readLine();
                }
                br.close();
            } catch (Exception err) {
                printAndExitApplication(ERROR_UNKNOWN);
            }
        }
    }

    /**
     * Method to display Greeting to the user
     * 
     */
    private static void displayGreeting() {
        showMessage("Welcome to TextBuddy. " + currentFilename
                + " is ready for use");
    }

    /**
     * Method to process commands entered by the user
     * 
     */
    private static void processUserInput() {

        boolean isExit = false;

        do {
            System.out.print(PROMPT_COMMAND);
            try {
                String userInput = reader.readLine().trim();
                COMMAND_TYPE command = findCommand(userInput);

                switch (command) {
                case ADD_LINE:
                    addLine(getParameter(userInput));
                    break;
                case DISPLAY:
                    displayAllLines();
                    break;
                case DELETE:
                    deleteLine(getParameter(userInput));
                    break;
                case CLEAR:
                    clearLines();
                    break;
                case EXIT:
                    saveContents();
                    isExit = true;
                    break;
                case INVALID:
                    displayHelpMessage();
                    break;
                default:
                    throw new Exception(ERROR_UNKNOWN);

                }

            } catch (Exception err) {
                printAndExitApplication(ERROR_UNKNOWN);
            }
        } while (!isExit);

    }

    private static void saveContents() {
        try {
            PrintWriter writer = new PrintWriter(currentFilename);
            for (String line : fileContent) {
                writer.println(line);
            }
            writer.close();
        } catch (Exception err) {
            printAndExitApplication(ERROR_WHILE_SAVING);
        }

    }

    private static void clearLines() {
        fileContent.removeAll(fileContent);
        displayClearAllMessage();
    }

    private static void displayClearAllMessage() {
        showMessage("all content deleted from " + currentFilename);
    }

    private static void deleteLine(String parameter) {
        if (fileContent.size() < 1 || parameter.isEmpty()) {
            showMessage("Nothing to delete");
            return;
        }
        
        int lineToBeDeleted = 0;
        
        try{
            lineToBeDeleted = Integer.parseInt(parameter);
        }catch(Exception err){
            return;
        }

        for (int i = 0; i < fileContent.size(); i++) {
            if (lineToBeDeleted == (i + 1)) {
                displayDeletedMessage(i);
                fileContent.remove(i);
                return;
            }
        }

    }

    private static void displayDeletedMessage(int i) {
        showMessage("deleted from " + currentFilename + ": \""
                + fileContent.get(i) + "\"");
    }

    private static void addLine(String parameter) {
        if (parameter.isEmpty()) {
            showMessage("Nothing to add");
            return;
        }
        fileContent.add(parameter);
        showMessage("added to " + currentFilename + ": \"" + parameter
                + "\"");
    }

    private static void displayAllLines() {
        int i = 1;
        if (fileContent.size() < 1) {
            displayEmptyFileMessage();
            return;
        }
        for (String line : fileContent) {
            showMessage(i + ". " + line);
            i++;
        }
    }

    private static void displayEmptyFileMessage() {
        showMessage(currentFilename + " is empty");
    }

    /**
     * Method to obtain the string after the command word. i.e. add a blue
     * cheese, return would be "a blue cheese"
     * 
     * @param userInput
     *            Input to be analyzed
     * @return String value
     */
    private static String getParameter(String userInput) {
        String[] pieces = userInput.split(" ", 2);

        if (userInput.isEmpty() || pieces.length < 2) {
            return "";
        }

        String value = pieces[1];

        return value.trim();
    }

    /**
     * Method used to find the command from the user input
     * 
     * @param input
     *            User input to be analyzed
     * @return Command to be executed
     */
    private static COMMAND_TYPE findCommand(String input) {
        if (input.isEmpty()) {
            return COMMAND_TYPE.INVALID;
        }
        String[] pieces = input.split(" ");
        String command = pieces[0];

        if (command.equalsIgnoreCase(COMMAND_FROM_CONSOLE[0])) {
            return COMMAND_TYPE.ADD_LINE;
        } else if (command.equalsIgnoreCase(COMMAND_FROM_CONSOLE[1])) {
            return COMMAND_TYPE.DISPLAY;
        } else if (command.equalsIgnoreCase(COMMAND_FROM_CONSOLE[2])) {
            return COMMAND_TYPE.DELETE;
        } else if (command.equalsIgnoreCase(COMMAND_FROM_CONSOLE[3])) {
            return COMMAND_TYPE.CLEAR;
        } else if (command.equalsIgnoreCase(COMMAND_FROM_CONSOLE[4])) {
            return COMMAND_TYPE.EXIT;
        } else {
            return COMMAND_TYPE.INVALID;
        }
    }

    /**
     * Method to print a help menu that shows all commands acceptable by the
     * application
     * 
     */
    private static void displayHelpMessage() {
        System.out.println(ERROR_ILLEGAL_COMMAND);
        for (int i = 0; i < COMMAND_FROM_CONSOLE.length; i++) {
            System.out.print(COMMAND_FROM_CONSOLE[i] + " ");
        }
        System.out.println();
    }

    /**
     * Method to display a message then quit the application
     * 
     * @param msg
     *            Message to be printed before quitting
     */
    private static void printAndExitApplication(String msg) {
        showMessage(msg);
        System.exit(0);
    }
    
    private static void showMessage(String message){
        System.out.println(message);
    }
}
