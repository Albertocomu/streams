package teoriaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class main {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        System.out.println("Find all transactions in 2011 and sort by value (small to high)");
        List<Transaction> tr2100 =
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(toList());

        System.out.println(tr2100);
        System.out.println();


        System.out.println("What are all the unique cities where the traders work?");
        List<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());

        /*
        Set<String> cities2 =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .collect(toSet());
        */

        System.out.println(cities);
        System.out.println();

        System.out.println("Find all traders from Cambridge and sort them by name");
        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        System.out.println();

        System.out.println("Listing 5.4. Return a string of all traders’ names sorted alphabetically");
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()).distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(traderStr);
        System.out.println();

        System.out.println("Listing 5.5. Are any traders based in Milan?");
        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));

        System.out.println(milanBased);
        System.out.println();

        System.out.println("Listing 5.6. Print all transactions’ values from the traders living in Cambridge");
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        System.out.println("5.7. What’s the highest value of all the transactions?");
        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);
        System.out.println(highestValue);
        System.out.println();

        System.out.println("5.8. Find the transaction with the smallest value");
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);

        System.out.println(smallestTransaction);
    }

}
