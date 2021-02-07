package pl.edu.pjwstk.mpr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class WeightedAverage {

    private final File testFile;

    public WeightedAverage(String filepath) {
        this.testFile = new File("./src/test/resources/" + filepath);
    }

    public WeightedAverage() {
        throw new IllegalArgumentException("File not specified.");
    }

    public double calculate() throws IOException, IllegalArgumentException {
        String fullPath = testFile.getPath();
        if (!fullPath.substring(fullPath.length() - 3).equals("txt"))
            throw new IllegalArgumentException("File have wrong format.");

        if (!testFile.exists())
            throw new IllegalArgumentException("File does not exist.");

        BigDecimal n1 = new BigDecimal(0);
        BigDecimal n2 = new BigDecimal(0);

        try (
                var fR = new FileReader(testFile);
                var reader = new BufferedReader(fR)
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                try {
                    var parts = getLineParts(line);
                    var no = Double.parseDouble(parts[0]);
                    var weight = Double.parseDouble(parts[1]);
                    n1 = n1.add(new BigDecimal(no * weight));
                    n2 = n2.add(new BigDecimal(weight));
                } catch (InvalidLineException ex) {
                    // dont do anything
                }
            }
        }
        if (n2 == new BigDecimal(0)) return 0;
        return n1.divide((n2)).doubleValue();
    }

    private String[] getLineParts(String line) throws InvalidLineException {
        var assert1 = line != null
                && !line.matches("\\s+")// contains spaces
                && !line.matches(".*[a-z].*"); // dont contain letters
        var parts = line.split("\\s+");
        var assert2 = parts.length == 2;
        if (!(assert1 && assert2)) throw new InvalidLineException("Validation failed.");
        return parts;
    }

}

class InvalidLineException extends Exception {
    public InvalidLineException(String message) {
        super(message);
    }
}