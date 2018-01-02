import java.time.LocalDate;

public class TradeStats {
    private String entity;
    private String buySellTag;
    private double agreedFx;
    private String currency;
    private LocalDate instructionDate;
    private LocalDate settlementDate;
    private int units;
    private double pricePerUnit;
    private double settledAmount;

    public TradeStats(String entity,
                      String buySellTag,
                      double agreedFx,
                      String currency,
                      LocalDate instructionDate,
                      LocalDate settlementDate,
                      int units,
                      double pricePerUnit,
                      double settledAmount) {
        this.entity = entity;
        this.buySellTag = buySellTag;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
        this.settledAmount = settledAmount;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getBuySellTag() {
        return buySellTag;
    }

    public void setBuySellTag(String buySellTag) {
        this.buySellTag = buySellTag;
    }

    public double getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(double agreedFx) {
        this.agreedFx = agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(double settledAmount) {
        this.settledAmount = settledAmount;
    }
}
