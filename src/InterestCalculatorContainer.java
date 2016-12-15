import java.util.ArrayList;
public abstract class InterestCalculatorContainer extends ArrayList<InterestCalculator> implements InterestCalculator {
    public double calculateInterest() {
        return this.stream()
            .mapToDouble(InterestCalculator::calculateInterest)
            .sum();
    }
}
