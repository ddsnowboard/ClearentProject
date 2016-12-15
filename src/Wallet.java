import java.util.ArrayList;
import java.util.List;

public class Wallet {
    List<CreditCard> cards = new ArrayList<>();

    public double calculateInterest()
    {
        return cards.stream()
            .mapToDouble(CreditCard::calculateInterest)
            .sum();
    }

    public void addCard(CreditCard card)
    {
        cards.add(card);
    }
}
