//My Solution
package org.example;

import java.util.Arrays;
import java.util.Scanner;

// Defines a class named "Question4"
public class Question4 {

    // Initialize to an empty string to store the result to be used in output
    private static String resultString;

    // Method for the "make" command
    public static String make(String command) {

        // Split the command into parts since it is a sentence
        String[] parts = command.split(" ");


        // Check if the command is valid
        if (parts.length < 3) {
            return "Invalid command format for 'make'.";
        }

        // Extract datatype and value from the command
        String action = parts[0];
        String dataType = parts[1];
        String value = parts[2];

        if ("string".equals(dataType)){
            resultString = value.toUpperCase();
            return resultString +  " as a String";
        }
        if ("integer".equals(dataType)){
            // Using parseInt method convert command string to integer
            int convertedInt = Integer.parseInt(value);
            int total = convertedInt + 1;
            resultString = String.valueOf(total);
            return resultString +  " as an int";
        }
        if ("double".equals(dataType)){
            // Using parseDouble method convert command string to double
            double convertedDouble = Double.parseDouble(value);
            double total = convertedDouble + 0.5;
            resultString = String.valueOf(total);
            return resultString +  " as a " + dataType;
        }
        if ("array".equals(dataType)){
            // Reverse the array by copying elements manually
            // Create an array of the items in the command, which will start at index 2 onwards

            int startIndex = 2;
            int endIndex = parts.length;

            String[] originalArray = new String[endIndex - startIndex];

            for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
                originalArray[j] = parts[i];
            }

            // Reversing the array
            String[] reversedArray = new String[originalArray.length];
            for (int i = 0; i < originalArray.length; i++) {
                reversedArray[i] = originalArray[originalArray.length - 1 - i];
            }
            resultString = Arrays.toString(reversedArray);
            return resultString +  " as an " + dataType;
        }
        return "Unknown command: " + action + " " + dataType + " " + value;
    }

    // Method for the "echo" command
    public static String echo(String command) {

        // Remove any leading or trailing white spaces first
        command = command.trim();

        // Split the command into parts since it is a sentence
        String[] parts = command.split(" ");

        // Check if the command is valid
        if (parts.length < 2) {
            return "Invalid command format.";
        }

        String action = parts[0];
        // Extract string to echo from the command
        resultString = command.substring(action.length()).trim();
        return  "echoed " + resultString;

    }

    // Method for the sum command
    public static String sum(String command) {
        // Split the command into the command itself and a list of numbers
        String[] parts = command.split("\\s+", 2);

        // Check if the command is valid
        if (parts.length < 2) {
            return "Invalid command format.";
        }

        // Extract string integers to sum from the command, at index 1
        String[] numbersAsString = parts[1].split(",");

        // Convert string integers to int and sum them
        int total = 0;
        for (String numStr : numbersAsString) {
            int num = Integer.parseInt(numStr.trim());
            total += num;
        }

        resultString = "the answer is " + total;
        return resultString;
    }

    // Method for the "read" command
    public static String read(String input) {
        // Check if the provided sting is empty
        if (input.isEmpty()) {
            return "Command cannot be an empty.";
        }

        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String lineResult = processCommand(line);
                output.append(lineResult).append("\n");

            }
        }

        return output.toString().trim();
    }

    public static String processCommand(String command) {
        String[] parts = command.split(" ");

        if (parts.length < 1) {
            return "Invalid command format.";
        }

        String action = parts[0];

        if ("make".equals(action)){
            // Using parseInt method convert command string to integer
            System.out.println("command " + command);
            return make(command);
        }
        if ("echo".equals(action)){
            // Using parseInt method convert command string to integer
            return echo(command);
        }
        if ("sum".equals(action)){
            // Using parseInt method convert command string to integer
            return sum(command);
        }
        return "Unknown command: " + action;
    }

    public static void main(String[] args) {
        // Example usage of the 'make' method
        String command = "make string Simon";
        String result = make(command);
        System.out.println(result);

        command = "make integer 5";
        result = make(command);
        System.out.println(result);

        command = "make double 6.25";
        result = make(command);
        System.out.println(result);

        command = "make array 1 simon 2 three";
        result = make(command);
        System.out.println(result);

        // Example usage of the 'echo' method
        command = "echo hello world";
        result = echo(command);
        System.out.println(result);

        command = "echo echo hello world";
        result = echo(command);
        System.out.println(result);

        command = "echo make string Simon";
        result = echo(command);
        System.out.println(result);

        // Example usage of the 'sum' method
        command = "sum 1,2,3,4,5";
        result = sum(command);
        System.out.println(result);

        command = "sum 1,2,3,4,-10";
        result = sum(command);
        System.out.println(result);

        command = "sum 1, 2, 3, 4, 5, 6, 0";
        result = sum(command);
        System.out.println(result);


        // Example usage of the 'read' method
        command = """
                sum 1,2,3,4,5
                echo hello world
                make string Simon
                make array 1 simon 2 three""";
        result = read(command);
        System.out.println(result);

        command = "";
        result = read(command);
        System.out.println(result);
    }
}

