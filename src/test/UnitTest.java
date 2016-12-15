import junit.framework.*;

public class UnitTest extends TestCase {
    public void test1()
    {
        MasterCard masterCard = new MasterCard();
        masterCard.setBalance(100);
        Visa visa = new Visa();
        visa.setBalance(100);
        Discover discover = new Discover();
        discover.setBalance(100);
        Wallet wallet = new Wallet();
        wallet.addCard(visa);
        wallet.addCard(masterCard);
        wallet.addCard(discover);
        Person person = new Person();
        person.addWallet(wallet);

        assertEquals(16.0, person.calculateInterest());

        assertEquals(1.0, discover.calculateInterest());
        assertEquals(5.0, masterCard.calculateInterest());
        assertEquals(10.0, visa.calculateInterest());
    }

    public void test2()
    {
        Wallet wallet1 = new Wallet();
        Visa visa = new Visa();
        visa.setBalance(100);
        Discover discover = new Discover();
        discover.setBalance(100);
        wallet1.addCard(visa);
        wallet1.addCard(discover);

        Wallet wallet2 = new Wallet();
        MasterCard masterCard = new MasterCard();
        masterCard.setBalance(100);
        wallet2.addCard(masterCard);

        Person person = new Person();
        person.addWallet(wallet1);
        person.addWallet(wallet2);


        assertEquals(16.0, person.calculateInterest());

        assertEquals(11.0, wallet1.calculateInterest());

        assertEquals(5.0, wallet2.calculateInterest());
    }

    public void test3()
    {
        Person p1 = new Person();
        Wallet wallet1 = new Wallet();
        p1.addWallet(wallet1);

        Visa visa1 = new Visa();
        visa1.setBalance(100);
        wallet1.addCard(visa1);

        MasterCard masterCard1 = new MasterCard();
        masterCard1.setBalance(100);
        wallet1.addCard(masterCard1);

        Discover discover1 = new Discover();
        discover1.setBalance(100);
        wallet1.addCard(discover1);
        
        assertEquals(16.0, wallet1.calculateInterest());
        assertEquals(16.0, p1.calculateInterest());




        Person p2 = new Person();
        Wallet wallet2 = new Wallet();
        p2.addWallet(wallet2);

        Visa visa2 = new Visa();
        visa2.setBalance(100);
        wallet2.addCard(visa2);

        MasterCard masterCard2 = new MasterCard();
        masterCard2.setBalance(100);
        wallet2.addCard(masterCard2);
        assertEquals(15.0, wallet2.calculateInterest());
        assertEquals(15.0, p2.calculateInterest());



        assertEquals(16.0, p1.calculateInterest());
    }
}
