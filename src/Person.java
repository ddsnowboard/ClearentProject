import java.util.List;
import java.util.ArrayList;


public class Person {
    private List<Wallet> wallets = new ArrayList<>();

    public double calculateInterest() {
        return wallets.stream()
            .mapToDouble(Wallet::calculateInterest)
            .sum();
    }

    public void addWallet(Wallet wallet)
    {
        wallets.add(wallet);
    }
}
