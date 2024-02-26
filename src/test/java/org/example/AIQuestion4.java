//AI Solution
package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AIQuestion4 {
    public static String make(String dataType, String... values) {
        switch (dataType) {
            case "string":
                return values[0].toUpperCase() + " as a String";
            case "integer":
                int intValue = Integer.parseInt(values[0]) + 1;
                return intValue + " as an int";
            case "double":
                double doubleValue = Double.parseDouble(values[0]) + 0.5;
                return doubleValue + " as a double";
            case "array":
                Collections.reverse(Arrays.asList(values));
                return Arrays.toString(values) + " as an array";
            default:
                return "Invalid command";
        }
    }

    public static String echo(String... words) {
        return "echoed " + String.join(" ", words);
    }

    public static String sum(String numbers) {
        int sum = Arrays.stream(numbers.split(","))
                .map(String::trim) // Add this line to trim whitespace from each number string
                .mapToInt(Integer::parseInt)
                .sum();
        return "the answer is " + sum;
    }

    public static String read(String... commands) {
        StringBuilder result = new StringBuilder();
        for (String command : commands) {
            String[] parts = command.split(" ");
            String cmd = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            switch (cmd) {
                case "make":
                    result.append(make(args[0], Arrays.copyOfRange(args, 1, args.length))).append("\n");
                    break;
                case "echo":
                    result.append(echo(args)).append("\n");
                    break;
                case "sum":
                    result.append(sum(String.join(",", args))).append("\n");
                    break;
                default:
                    result.append("Invalid command\n");
            }
        }
        return result.toString().trim();
    }

}
