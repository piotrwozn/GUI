package Train.WagonsTypes;

public class LiquidWagon extends BasicFreightWagon{
    private final String liquidType;
    private final double maxCapacity;
    private final WagonType wagonType;

    public LiquidWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int doorsCount, int handleCount, String liquidType, double maxCapacity) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, doorsCount, handleCount);
        this.liquidType = liquidType;
        this.maxCapacity = maxCapacity;
        this.wagonType = WagonType.LiquidWagon;
    }

    @Override
    public String toString() {
        return "LiquidWagon{" +
                "liquidType='" + liquidType + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", wagonType=" + wagonType +
                '}';
    }

    @Override
    public WagonType getWagonType() {
        return wagonType;
    }
}
