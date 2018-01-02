public class SettlementDateAdjuster {

    public static void isSettlementDateWorkDay(TradeStats trade) {
        if (trade.getCurrency() == "AED" || trade.getCurrency() == "SAR"){
            switch (trade.getSettlementDate().getDayOfWeek()){
                case FRIDAY:
                    trade.setSettlementDate(trade.getSettlementDate().plusDays(2));
                    break;
                case SATURDAY:
                    trade.setSettlementDate(trade.getSettlementDate().plusDays(1));
                    break;
            }

        } else {
            switch (trade.getSettlementDate().getDayOfWeek()){
                case SATURDAY:
                    trade.setSettlementDate(trade.getSettlementDate().plusDays(2));
                    break;
                case SUNDAY:
                    trade.setSettlementDate(trade.getSettlementDate().plusDays(1));
                    break;
            }
        }
    }

}
