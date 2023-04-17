package Train.WagonsTypes;

public class LuggagePostWagon extends Wagon{
    private final int maxLuggageCount;
    private final int luggageCompartmentsCount;
    private final WagonType wagonType;

    public LuggagePostWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int maxLuggageCount, int luggageCompartmentsCount) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.maxLuggageCount = maxLuggageCount;
        this.luggageCompartmentsCount = luggageCompartmentsCount;
        this.wagonType = WagonType.LuggagePostWagon;
    }

    @Override
    public String toString() {
        return "LuggagePostWagon{" +
                "maxLuggageCount=" + maxLuggageCount +
                ", luggageCompartmentsCount=" + luggageCompartmentsCount +
                ", wagonType=" + wagonType +
                '}';
    }

    public WagonType getWagonType() {
        return wagonType;
    }
}
