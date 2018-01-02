import java.util.Vector;

/*
   This class is treated as a database hence why the stringToLocalDateParser method is invoked from another class.
   In a real world scenario the method will be used in its class and the below values will be inserted with an
   SQL for example, but for the sake of readability they are used in-place here.
 */
public class MockDB {
    static Vector<TradeStats> trades = new Vector<>();

    public static void populateTrades(){
        TradeStats tradeFooB = new TradeStats("foo", "B", 0.5,  "SGP", MoneyInOutCalculator.stringToLocalDateParser("01/01/2016"), MoneyInOutCalculator.stringToLocalDateParser("02/01/2016"), 200, 100.25, 0);
        TradeStats tradeFooS = new TradeStats("foo", "S", 0.5,  "SGP", MoneyInOutCalculator.stringToLocalDateParser("05/01/2016"), MoneyInOutCalculator.stringToLocalDateParser("07/01/2016"), 970, 100.25, 0);
        TradeStats tradeBarB = new TradeStats("bar", "B", 0.22, "AED", MoneyInOutCalculator.stringToLocalDateParser("01/01/2016"), MoneyInOutCalculator.stringToLocalDateParser("02/01/2016"), 500, 150.5,  0);
        TradeStats tradeBarS = new TradeStats("bar", "S", 0.22, "AED", MoneyInOutCalculator.stringToLocalDateParser("05/01/2016"), MoneyInOutCalculator.stringToLocalDateParser("07/01/2016"), 450, 150.5,  0);

        trades.add(tradeFooB);
        trades.add(tradeFooS);
        trades.add(tradeBarB);
        trades.add(tradeBarS);
    }
}
