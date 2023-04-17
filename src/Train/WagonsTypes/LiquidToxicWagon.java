package Train.WagonsTypes;

public class LiquidToxicWagon extends HeavyFreightWagon{
    private final boolean harmsEnvironment;
    private final double concentration;
    private final String liquidType;
    private final double maxCapacity;
    private final int doorsCount;
    private final int handleCount;
    private final WagonType wagonType;

    public LiquidToxicWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, String additionalDevices, String adaptation, boolean harmsEnvironment, double concentration, String liquidType, double maxCapacity, int doorsCount, int handleCount) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, additionalDevices, adaptation);
        this.harmsEnvironment = harmsEnvironment;
        this.concentration = concentration;
        this.liquidType = liquidType;
        this.maxCapacity = maxCapacity;
        this.doorsCount = doorsCount;
        this.handleCount = handleCount;
        this.wagonType = WagonType.LiquidToxicWagon;
    }

    @Override
    public String toString() {
        return "LiquidToxicWagon{" +
                "harmsEnvironment=" + harmsEnvironment +
                ", concentration=" + concentration +
                ", liquidType='" + liquidType + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", doorsCount=" + doorsCount +
                ", handleCount=" + handleCount +
                ", wagonType=" + wagonType +
                '}';
    }

    @Override
    public WagonType getWagonType() {
        return wagonType;
    }
}
