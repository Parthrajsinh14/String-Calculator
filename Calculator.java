import java.util.regex.*;
import java.util.*;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//[")) {
            List<String> delimiters = new ArrayList<>();
            Matcher m = Pattern.compile("\\[(.*?)]").matcher(numbers);
            int lastMatchEnd = 0;

            while (m.find()) {
                delimiters.add(Pattern.quote(m.group(1)));
                lastMatchEnd = m.end();
            }

            delimiter = String.join("|", delimiters);
            numbers = numbers.substring(lastMatchEnd + 1); // skip \n
        } else if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterEnd));
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int num = Integer.parseInt(part.trim());
                if (num < 0) {
                    negatives.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}
