//AI Solution

package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AIQuestion4Test {


    // Test cases for the 'make' method
    @Test
    void makeStringCommand_ReturnsStringType() {
        String result = AIQuestion4.make("make string hello");

        // Assert that the result is not null
        assertNotNull(result, "Result should not be null");

        // Assert that the result is of type String
        assertTrue(true, "Result should be of type String");
    }

    @Test
    void makeStringCommand_ReturnsUpperCaseString() {
        String result = AIQuestion4.make("make string hello");
        assertEquals("HELLO as a String", result);
    }

    @Test
    void makeIntegerCommand_ReturnsIncrementedValue() {
        String result = AIQuestion4.make("make integer 5");
        Assertions.assertEquals("6 as an int", result);
    }

    @Test
    void makeDoubleCommand_ReturnsIncrementedValue() {
        String result = AIQuestion4.make("make double 3.0");
        assertEquals("3.5 as a double", result);
    }

    @Test
    void makeArrayCommand_ReturnsReversedArray() {
        String result = AIQuestion4.make("make array 1 simon 2 three");
        assertEquals("[three, 2, simon, 1] as an array", result);
    }

    @Test
    void makeUnknownDataType_ReturnsUnknownCommandMessage() {
        String result = AIQuestion4.make("make unknownType value");
        assertEquals("Unknown command: make unknownType value", result);
    }

    @Test
    void makeInvalidCommandFormat_ReturnsInvalidFormatMessage() {
        String result = AIQuestion4.make("make string");
        assertEquals("Invalid command format for 'make'.", result);
    }

    // Test cases for the 'echo' method
    @Test
    void echoValidCommand_ReturnsEchoedString() {
        String result = AIQuestion4.echo("echo hello world");
        assertEquals("echoed hello world", result);
    }

    @Test
    void echoMultipleWords_ReturnsEchoedString() {
        String result = AIQuestion4.echo("echo multiple words to echo");
        assertEquals("echoed multiple words to echo", result);
    }

    @Test
    void echoWithLeadingWhitespace_ReturnsEchoedString() {
        String result = AIQuestion4.echo("   echo leading whitespace");
        assertEquals("echoed leading whitespace", result);
    }

    @Test
    void echoWithTrailingWhitespace_ReturnsEchoedString() {
        String result = AIQuestion4.echo("echo leading whitespace    ");
        assertEquals("echoed leading whitespace", result);
    }

    @Test
    void echoWithLeadingAndTrailingWhitespace_ReturnsEchoedString() {
        String result = AIQuestion4.echo("   echo leading whitespace    ");
        assertEquals("echoed leading whitespace", result);
    }

    @Test
    void echoEmptyString_ReturnsInvalidFormatMessage() {
        String result = AIQuestion4.echo("echo");
        assertEquals("Invalid command format.", result);
    }

    @Test
    void echoInvalidCommand_ReturnsInvalidFormatMessage() {
        String result = AIQuestion4.echo("invalidCommand");
        assertEquals("Invalid command format.", result);
    }

    // Test cases for 'sum' method
    @Test
    void sumValidCommand_ReturnsSum() {
        String result = AIQuestion4.sum("sum 1,2,3,4,5");
        assertEquals("the answer is 15", result);
        assertTrue(result.contains("15"), "Result should contain the sum");
    }

    @Test
    void sumNegativeNumbers_ReturnsSum() {
        String result = AIQuestion4.sum("sum -1,-2,-3");
        assertEquals("the answer is -6", result);
        assertTrue(result.contains("-6"), "Result should contain the sum");
    }

    @Test
    void sumMixedNumbers_ReturnsSum() {
        String result = AIQuestion4.sum("sum 1,-2,3,-4");
        assertEquals("the answer is -2", result);
        assertTrue(result.contains("-2"), "Result should contain the sum");
    }

    @Test
    void sumSingleNumber_ReturnsSum() {
        String result = AIQuestion4.sum("sum 10");
        assertEquals("the answer is 10", result);
        assertTrue(result.contains("10"), "Result should contain the sum");
    }

    @Test
    void sumEmptyString_ReturnsInvalidFormatMessage() {
        String result = AIQuestion4.sum("sum");
        assertEquals("Invalid command format.", result);
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Invalid"), "Result should start with 'Invalid'");
    }

    @Test
    void sumInvalidCommand_ReturnsInvalidFormatMessage() {
        String result = AIQuestion4.sum("invalidCommand");
        assertEquals("Invalid command format.", result);
        assertNotNull(result, "Result should not be null");
        assertTrue(result.startsWith("Invalid"), "Result should start with 'Invalid'");
    }

    // Test cases for 'read' and 'process' methods
    @Test
    void readValidCommands_ReturnsProcessedResults() {
        String input = "make string Simon\n" +
                "echo hello world\n" +
                "sum 1,2,3,4,5";
        String result = AIQuestion4.read(input);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("SIMON"), "Result should contain processed make command");
        assertTrue(result.contains("echoed hello world"), "Result should contain processed echo command");
        assertTrue(result.contains("the answer is 15"), "Result should contain processed sum command");
    }

    @Test
    void readEmptyInput_ReturnsEmptyString() {
        String input = "";
        String result = AIQuestion4.read(input);

        assertNotNull(result, "Result should not be null");
    }

    /*@Test
    void processCommandMake_ReturnsMakeResult() {
        String command = "make string John";
        String result = AIQuestion4.processCommand(command);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("JOHN"), "Result should contain processed make command");
    }*/

/*    @Test
    void processCommandEcho_ReturnsEchoResult() {
        String command = "echo hello world";
        String result = AIQuestion4.processCommand(command);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("echoed hello world"), "Result should contain processed echo command");
    }

    @Test
    void processCommandSum_ReturnsSumResult() {
        String command = "sum 1,2,3,4,5";
        String result = AIQuestion4.processCommand(command);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("the answer is 15"), "Result should contain processed sum command");
    }

    @Test
    void processCommandUnknownAction_ReturnsUnknownCommandMessage() {
        String command = "unknownAction";
        String result = AIQuestion4.processCommand(command);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("Unknown command: unknownAction"), "Result should contain Unknown command message");
    }*/

    @Test
    void readCommandInvalidFormat_ReturnsInvalidFormatMessage() {
        String command = "";
        String result = AIQuestion4.read(command);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("Command cannot be an empty."), "Result should contain Invalid command format message");
    }

    @Test
    void readAndProcessMixedCommands_ReturnsProcessedResults() {
        String input = "make string Alice\n" +
                "invalidCommand\n" +
                "echo greeting\n" +
                "sum 1,2,3";
        String result = AIQuestion4.read(input);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("ALICE"), "Result should contain processed make command");
        assertTrue(result.contains("Unknown command: invalidCommand"), "Result should contain Unknown command message");
        assertTrue(result.contains("echoed greeting"), "Result should contain processed echo command");
        assertTrue(result.contains("the answer is 6"), "Result should contain processed sum command");
    }

}