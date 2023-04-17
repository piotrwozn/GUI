package Train.WagonsTypes;

public class HeavyFreightWagon extends Wagon{
    private final String additionalDevices;
    private final String adaptation;
    private final WagonType wagonType;

    public HeavyFreightWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, String additionalDevices, String adaptation) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.additionalDevices = additionalDevices;
        this.adaptation = adaptation;
        this.wagonType = WagonType.HeavyFreightWagon;
    }

    @Override
    public String toString() {
        return "HeavyFreightWagon{" +
                "additionalDevices='" + additionalDevices + '\'' +
                ", adaptation='" + adaptation + '\'' +
                ", wagonType=" + wagonType +
                '}';
    }

    public WagonType getWagonType() {
        return wagonType;
    }
}
