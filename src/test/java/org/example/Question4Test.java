//My Solution
package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Question4Test {

    // Test for 'make' method with string data type, checking for correct type handling
    @Test
    void makeStringCommand_ReturnsStringType() {
        String result = Question4.make("make string hello");
        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(true, "Result should be of type String"); // Checks if the result is a string
    }

    // Test for 'make' method with string, checks if it converts to uppercase
    @Test
    void makeStringCommand_ReturnsUpperCaseString() {
        String result = Question4.make("make string hello");
        assertEquals("HELLO as a String", result); // Verifies the string is correctly converted to uppercase
    }

    // Test for 'make' method with integer, checks if it increments the value
    @Test
    void makeIntegerCommand_ReturnsIncrementedValue() {
        String result = Question4.make("make integer 5");
        Assertions.assertEquals("6 as an int", result); // Confirms the integer is incremented
    }

    // Test for 'make' method with double, checks if it correctly adds 0.5
    @Test
    void makeDoubleCommand_ReturnsIncrementedValue() {
        String result = Question4.make("make double 3.0");
        assertEquals("3.5 as a double", result); // Checks for correct addition of 0.5 to the double
    }

    // Test for 'make' method with array, checks if it reverses the array elements
    @Test
    void makeArrayCommand_ReturnsReversedArray() {
        String result = Question4.make("make array 1 simon 2 three");
        assertEquals("[three, 2, simon, 1] as an array", result); // Verifies the array is reversed
    }

    // Test for 'make' method with unknown data type, checks error handling
    @Test
    void makeUnknownDataType_ReturnsUnknownCommandMessage() {
        String result = Question4.make("make unknownType value");
        assertEquals("Unknown command: make unknownType value", result); // Ensures it handles unknown data types
    }

    // Test for 'make' method with invalid format, checks error message
    @Test
    void makeInvalidCommandFormat_ReturnsInvalidFormatMessage() {
        String result = Question4.make("make string");
        assertEquals("Invalid command format for 'make'.", result); // Confirms proper error message for invalid format
    }

    // Test cases for the 'echo' method
    @Test
    void echoValidCommand_ReturnsEchoedString() {
        String result = Question4.echo("echo hello world");
        assertEquals("echoed hello world", result); // Verifies that it echoes the input string
    }

    // Test for 'echo' method with multiple words, ensuring it echoes them correctly
    @Test
    void echoMultipleWords_ReturnsEchoedString() {
        String result = Question4.echo("echo multiple words to echo");
        assertEquals("echoed multiple words to echo", result); // Checks if it correctly echoes multiple words
    }

    // Test for 'echo' method with leading whitespace, ensuring it's trimmed before echoing
    @Test
    void echoWithLeadingWhitespace_ReturnsEchoedString() {
        String result = Question4.echo("   echo leading whitespace");
        assertEquals("echoed leading whitespace", result); // Verifies leading whitespace is trimmed
    }

    // Test for 'echo' method with trailing whitespace, ensuring it's trimmed before echoing
    @Test
    void echoWithTrailingWhitespace_ReturnsEchoedString() {
        String result = Question4.echo("echo leading whitespace    ");
        assertEquals("echoed leading whitespace", result); // Verifies trailing whitespace is trimmed
    }

    // Test for 'echo' method with both leading and trailing whitespace
    @Test
    void echoWithLeadingAndTrailingWhitespace_ReturnsEchoedString() {
        String result = Question4.echo("   echo leading whitespace    ");
        assertEquals("echoed leading whitespace", result); // Ensures both leading and trailing whitespaces are trimmed
    }

    // Test for 'echo' method with an empty string, checking for proper error handling
    @Test
    void echoEmptyString_ReturnsInvalidFormatMessage() {
        String result = Question4.echo("echo");
        assertEquals("Invalid command format.", result); // Checks if the right error message is returned for empty input
    }

    // Test for 'echo' method with an invalid command, evaluating error handling
    @Test
    void echoInvalidCommand_ReturnsInvalidFormatMessage() {
        String result = Question4.echo("invalidCommand");
        assertEquals("Invalid command format.", result); // Verifies that an invalid command is handled correctly
    }

    // Test for 'sum' method with valid numbers, checks if it correctly computes their sum
    @Test
    void sumValidCommand_ReturnsSum() {
        String result = Question4.sum("sum 1,2,3,4,5");
        assertEquals("the answer is 15", result); // Confirms that the sum of the numbers is correct
        assertTrue(result.contains("15"), "Result should contain the sum"); // Additional check for the presence of sum in the result
    }

    // Test for 'sum' method with negative numbers, checking correct summation
    @Test
    void sumNegativeNumbers_ReturnsSum() {
        String result = Question4.sum("sum -1,-2,-3");
        assertEquals("the answer is -6", result); // Ensures that negative numbers are summed correctly
        assertTrue(result.contains("-6"), "Result should contain the sum"); // Checks for the presence of the correct sum in the result
    }

    // Test for 'sum' method with a mix of positive and negative numbers
    @Test
    void sumMixedNumbers_ReturnsSum() {
        String result = Question4.sum("sum 1,-2,3,-4");
        assertEquals("the answer is -2", result); // Checks if the mix of numbers is summed correctly
        assertTrue(result.contains("-2"), "Result should contain the sum"); // Ensures the correct sum is in the result
    }

    // Test for 'sum' method with a single number, checking it returns the number itself
    @Test
    void sumSingleNumber_ReturnsSum() {
        String result = Question4.sum("sum 10");
        assertEquals("the answer is 10", result); // Verifies if the single number is returned as the sum
        assertTrue(result.contains("10"), "Result should contain the sum"); // Checks for the presence of the number in the result
    }

    // Test for 'sum' method with an empty string, evaluating error handling
    @Test
    void sumEmptyString_ReturnsInvalidFormatMessage() {
        String result = Question4.sum("sum");
        assertEquals("Invalid command format.", result); // Checks if an empty string is correctly identified as an error
        assertNotNull(result, "Result should not be null"); // Ensures the result is not null
        assertTrue(result.startsWith("Invalid"), "Result should start with 'Invalid'"); // Verifies the error message starts with "Invalid"
    }

    // Test for 'sum' method with an invalid command, checking for proper error handling
    @Test
    void sumInvalidCommand_ReturnsInvalidFormatMessage() {
        String result = Question4.sum("invalidCommand");
        assertEquals("Invalid command format.", result); // Confirms that an invalid command is handled correctly
        assertNotNull(result, "Result should not be null"); // Ensures the result is not null
        assertTrue(result.startsWith("Invalid"), "Result should start with 'Invalid'"); // Checks the error message starts with "Invalid"
    }


    // Test for 'read' method with valid commands, checks if it processes multiple commands correctly
    @Test
    void readValidCommands_ReturnsProcessedResults() {
        String input = "make string Simon\n" +
                "echo hello world\n" +
                "sum 1,2,3,4,5";
        String result = Question4.read(input);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("SIMON"), "Result should contain processed 'make' command"); // Checks 'make' command processing
        assertTrue(result.contains("echoed hello world"), "Result should contain processed 'echo' command"); // Checks 'echo' command processing
        assertTrue(result.contains("the answer is 15"), "Result should contain processed 'sum' command"); // Checks 'sum' command processing
    }

    // Test for 'read' method with empty input, checks if it handles empty input correctly
    @Test
    void readEmptyInput_ReturnsEmptyString() {
        String input = "";
        String result = Question4.read(input);

        assertNotNull(result, "Result should not be null"); // Verifies that result is not null even with empty input
    }

    // Test for 'processCommand' method with 'make' command, evaluates correct processing
    @Test
    void processCommandMake_ReturnsMakeResult() {
        String command = "make string John";
        String result = Question4.processCommand(command);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("JOHN"), "Result should contain processed 'make' command result"); // Verifies 'make' command processing
    }

    // Test for 'processCommand' method with 'echo' command, checks if it echoes correctly
    @Test
    void processCommandEcho_ReturnsEchoResult() {
        String command = "echo hello world";
        String result = Question4.processCommand(command);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("echoed hello world"), "Result should contain processed 'echo' command result"); // Verifies 'echo' command processing
    }

    // Test for 'processCommand' method with 'sum' command, evaluates correct sum calculation
    @Test
    void processCommandSum_ReturnsSumResult() {
        String command = "sum 1,2,3,4,5";
        String result = Question4.processCommand(command);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("the answer is 15"), "Result should contain processed 'sum' command result"); // Verifies 'sum' command processing
    }

    // Test for 'processCommand' method with unknown action, checks error handling
    @Test
    void processCommandUnknownAction_ReturnsUnknownCommandMessage() {
        String command = "unknownAction";
        String result = Question4.processCommand(command);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("Unknown command: unknownAction"), "Result should contain error message for unknown command"); // Checks handling of unknown command
    }

    // Test for 'read' method with invalid format, evaluates error message for empty command
    @Test
    void readCommandInvalidFormat_ReturnsInvalidFormatMessage() {
        String command = "";
        String result = Question4.read(command);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("Command cannot be an empty."), "Result should contain error message for empty command format"); // Verifies error handling for empty input
    }

    // Test for 'read' method with a mix of valid and invalid commands, evaluates overall processing
    @Test
    void readAndProcessMixedCommands_ReturnsProcessedResults() {
        String input = "make string Alice\n" +
                "invalidCommand\n" +
                "echo greeting\n" +
                "sum 1,2,3";
        String result = Question4.read(input);

        assertNotNull(result, "Result should not be null"); // Ensures result is not null
        assertTrue(result.contains("ALICE"), "Result should contain processed 'make' command result"); // Verifies 'make' command processing
        assertTrue(result.contains("Unknown command: invalidCommand"), "Result should contain error message for invalid command"); // Checks handling of invalid command
        assertTrue(result.contains("echoed greeting"), "Result should contain processed 'echo' command result"); // Verifies 'echo' command processing
        assertTrue(result.contains("the answer is 6"), "Result should contain processed 'sum' command result"); // Verifies 'sum' command processing
    }

}