package pl.edu.pjwstk.mpr;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WeightedAverageTest {

    private void printResult(double avg) {
        var res = removeTrailingDotAndZeros(avg);
        System.out.println(String.format("Calculated average: %s", res));
    }

    private boolean isLastCharDotOrZero(char text) {
        return text == '.' || text == '0';
    }

    private String removeTrailingDotAndZeros(double val) {
        var res = String.valueOf(val);
        while (isLastCharDotOrZero(res.charAt(res.length() - 1)))
            res = res.substring(0, res.length() - 1);
        return res;
    }

    @Test
    public void file_not_specified_test() {
        assertThatThrownBy(WeightedAverage::new)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not specified.");
    }

    @Test
    public void removeTrailingDotAndZeros_test() {
        var input = 3.00;
        var res = removeTrailingDotAndZeros(input);
        System.out.println(String.format("Trailed zeros: Input: %s | Res: %s", input, res));
        assertThat(res).isEqualTo("3");
    }

    @Test
    public void should_calcuate_simple_avg_small() throws IOException {
        var average = new WeightedAverage("test_avg_small.txt");
        double avg = average.calculate();
        printResult(avg);
        assertThat(avg).isEqualTo(3.125);
    }

    @Test
    public void should_calcuate_simple_avg_small_with_junk() throws IOException {
        var average = new WeightedAverage("test_avg_small_junk.txt");
        double avg = average.calculate();
        printResult(avg);
        assertThat(avg).isEqualTo(3.125);
    }

    @Test
    public void should_calcuate_simple_avg_big() throws IOException {
        var average = new WeightedAverage("test_avg_big.txt");
        double avg = average.calculate();
        printResult(avg);
        assertThat(avg).isEqualTo(14.45);
    }

    @Test
    public void should_throw_when_file_not_exists() {
        var average = new WeightedAverage("asd.txt");
        assertThatThrownBy(average::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File does not exist.");
    }

    @Test
    public void should_throw_when_specified_file_have_wrong_format() {
        var average = new WeightedAverage("asd.lol");
        assertThatThrownBy(average::calculate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File have wrong format.");
    }

}