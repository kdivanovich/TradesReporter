import java.util.Vector;

/*Just a few mock tests that can be run from the TransactionReporter's Main class, mocked so I don't have to create an explicit .pom and add the dependency,
* but to demonstrate how it works more or less.
*/

public class MockUnitTests {

    public void PrintTheDB() {
        Vector<TradeStats> tradesWithIncomingUSDValues = new Vector<>();
        Vector<TradeStats> tradesWithOutcomingUSDValues = new Vector<>();

        for (int i = 0; i < MockDB.trades.size(); i++) {
            if (MockDB.trades.elementAt(i).getBuySellTag() == "B") {
                tradesWithOutcomingUSDValues.add(MockDB.trades.elementAt(i));
            } else
                tradesWithIncomingUSDValues.add(MockDB.trades.elementAt(i));
        }

        for (int i = 0; i < tradesWithIncomingUSDValues.size(); i++) {
            TradeStats trade = tradesWithIncomingUSDValues.elementAt(i);
            System.out.println(trade.getEntity() + ", " +
                    trade.getBuySellTag() + ", " +
                    trade.getAgreedFx() + ", " +
                    trade.getCurrency() + ", " +
                    trade.getInstructionDate() + ", " +
                    trade.getSettlementDate() + ", " +
                    trade.getUnits() + ", " +
                    trade.getPricePerUnit() + ", " +
                    trade.getSettledAmount());
        }
        for (int i = 0; i < tradesWithOutcomingUSDValues.size(); i++) {
            TradeStats trade = tradesWithOutcomingUSDValues.elementAt(i);
            System.out.println(trade.getEntity() + ", " +
                    trade.getBuySellTag() + ", " +
                    trade.getAgreedFx() + ", " +
                    trade.getCurrency() + ", " +
                    trade.getInstructionDate() + ", " +
                    trade.getSettlementDate() + ", " +
                    trade.getUnits() + ", " +
                    trade.getPricePerUnit() + ", " +
                    trade.getSettledAmount());
        }
        System.out.println();
    }

    //@Test
    public static void aa() {
        TradeStats tradeFooB = MockDB.trades.elementAt(0);
        TradeStats tradeBarB = MockDB.trades.elementAt(2);

        SettlementDateAdjuster.isSettlementDateWorkDay(tradeBarB);
        tradeBarB.setSettlementDate(MoneyInOutCalculator.stringToLocalDateParser("09/09/2018"));
        System.out.println(tradeBarB.getSettlementDate() + " --- " + tradeBarB.getSettlementDate().getDayOfWeek());
        //AssertEquals(tradeBarB.getSettlementDate(), 2018-09-09);
        //AssertEquals(tradeBarB.getSettlementDate().getDayOfWeek(), DayOfWeek.SUNDAY)

        MoneyInOutCalculator.amountSettledCalculator(tradeFooB);
        //AssertEquals(MoneyInOutCalculator.amountSettledCalculator(tradeFooB), 10025.0);
        System.out.println(tradeFooB.getSettledAmount());
    }


}
