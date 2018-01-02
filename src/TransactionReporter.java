import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class TransactionReporter {

    public static void main(String[] args) {

        Vector<TradeStats> trades = MockDB.trades;
        MockDB.populateTrades();

        for (int i = 0; i < MockDB.trades.size(); i++) {
            SettlementDateAdjuster.isSettlementDateWorkDay(MockDB.trades.elementAt(i));
            MoneyInOutCalculator.amountSettledCalculator(MockDB.trades.elementAt(i));
        }

        Vector<TradeStats> tradesWithIncomingUSDValues = new Vector<>();
        Vector<TradeStats> tradesWithOutcomingUSDValues = new Vector<>();

        for (int i = 0; i < MockDB.trades.size(); i++) {
            if (MockDB.trades.elementAt(i).getBuySellTag() == "B") {
                tradesWithOutcomingUSDValues.add(MockDB.trades.elementAt(i));
            } else
                tradesWithIncomingUSDValues.add(MockDB.trades.elementAt(i));
        }

        Vector<LocalDate> uniqueDates = new Vector<>();
        for (int i = 0; i < trades.size(); i++) {
            if (!uniqueDates.contains(trades.elementAt(i).getSettlementDate())) {
                uniqueDates.add(trades.elementAt(i).getSettlementDate());
            }
        }
        Collections.sort(uniqueDates);

        System.out.println("--------- Incoming Amounts: ------------");
        for (int i = 0; i < uniqueDates.size(); i++){
            Boolean dateAlreadyPrinted = false;
            for (int j = 0; j < tradesWithIncomingUSDValues.size(); j++){
                if (uniqueDates.elementAt(i).isEqual(tradesWithIncomingUSDValues.elementAt(j).getSettlementDate())) {
                    if (dateAlreadyPrinted == false) {
                        System.out.println("Amounts Settled for " + uniqueDates.elementAt(i) + ":");
                        dateAlreadyPrinted = true;
                    }
                    System.out.println(uniqueDates.elementAt(i) + ", " + tradesWithIncomingUSDValues.elementAt(j).getEntity() + " - $" + tradesWithIncomingUSDValues.elementAt(j).getSettledAmount());
                }
            }
        }

        System.out.println("--------- Outcoming Amounts: -----------");
        for (int i = 0; i < uniqueDates.size(); i++){
            Boolean dateAlreadyPrinted = false;
            for (int j = 0; j < tradesWithOutcomingUSDValues.size(); j++){
                if (uniqueDates.elementAt(i).isEqual(tradesWithOutcomingUSDValues.elementAt(j).getSettlementDate())) {
                    if (dateAlreadyPrinted == false) {
                        System.out.println("Amounts Settled for " + uniqueDates.elementAt(i) + ":");
                        dateAlreadyPrinted = true;
                    }
                    System.out.println(uniqueDates.elementAt(i) + ", " + tradesWithOutcomingUSDValues.elementAt(j).getEntity() + " - $" + tradesWithOutcomingUSDValues.elementAt(j).getSettledAmount());
                }
            }
        }
        System.out.println("----------------------------------------");


        System.out.println("Entities ranking by top grossing:");
        System.out.println("\nTop Incoming:");

        Collections.sort(tradesWithIncomingUSDValues, new Comparator<TradeStats>() {
            @Override
            public int compare(TradeStats o1, TradeStats o2) {
                return Double.compare(o1.getSettledAmount(), o2.getSettledAmount());
            }
        });

        Collections.reverse(tradesWithIncomingUSDValues);

        for (int i = 0; i < tradesWithIncomingUSDValues.size(); i++){
            System.out.println((i+1) + ". " + tradesWithIncomingUSDValues.elementAt(i).getEntity() + " - " + tradesWithIncomingUSDValues.elementAt(i).getSettledAmount());
        }

        System.out.println("\nTop Outcoming:");

        Collections.sort(tradesWithOutcomingUSDValues, new Comparator<TradeStats>() {
            @Override
            public int compare(TradeStats o1, TradeStats o2) {
                return Double.compare(o1.getSettledAmount(), o2.getSettledAmount());
            }
        });

        Collections.reverse(tradesWithOutcomingUSDValues);

        for (int i = 0; i < tradesWithOutcomingUSDValues.size(); i++){
            System.out.println((i+1) + ". " + tradesWithOutcomingUSDValues.elementAt(i).getEntity() + " - " + tradesWithOutcomingUSDValues.elementAt(i).getSettledAmount());
        }


        // For the mock tests example:
        //MockUnitTests.aa();

    }
}
