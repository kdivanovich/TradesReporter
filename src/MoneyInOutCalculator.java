import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MoneyInOutCalculator {

    public static void amountSettledCalculator(TradeStats trade) {
        trade.setSettledAmount(trade.getPricePerUnit() * trade.getUnits() * trade.getAgreedFx());
    }

    public static LocalDate stringToLocalDateParser(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(stringDate, formatter);
    }

}
