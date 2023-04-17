package Train.WagonsTypes;

public class GasWagon extends BasicFreightWagon{
    private final String gasType;
    private final double maxVolume;
    private final WagonType wagonType;

    public GasWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int doorsCount, int handleCount, String gasType, double maxVolume) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, doorsCount, handleCount);
        this.gasType = gasType;
        this.maxVolume = maxVolume;
        this.wagonType = WagonType.GasWagon;
    }

    @Override
    public String toString() {
        return "GasWagon{" +
                "gasType='" + gasType + '\'' +
                ", maxVolume=" + maxVolume +
                ", wagonType=" + wagonType +
                '}';
    }

    @Override
    public WagonType getWagonType() {
        return wagonType;
    }
}
