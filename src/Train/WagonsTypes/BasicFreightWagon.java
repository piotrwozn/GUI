package Train.WagonsTypes;

public class BasicFreightWagon extends Wagon{
    private final int doorsCount;
    private final int handleCount;
    private final WagonType wagonType;

    public BasicFreightWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int doorsCount, int handleCount) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.doorsCount = doorsCount;
        this.handleCount = handleCount;
        this.wagonType = WagonType.BasicFreightWagon;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    @Override
    public String toString() {
        return "BasicFreightWagon{" +
                "doorsCount=" + doorsCount +
                ", handleCount=" + handleCount +
                ", wagonType=" + wagonType +
                '}';
    }
}
