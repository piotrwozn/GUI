package Train.WagonsTypes;

public class ToxicWagon extends HeavyFreightWagon{
    private final boolean isRadioactive;
    private final boolean isHarmful;
    private final WagonType wagonType;

    public ToxicWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, String additionalDevices, String adaptation, boolean isRadioactive, boolean isHarmful) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, additionalDevices, adaptation);
        this.isRadioactive = isRadioactive;
        this.isHarmful = isHarmful;
        this.wagonType = WagonType.ToxicWagon;
    }

    @Override
    public String toString() {
        return "ToxicWagon{" +
                "isRadioactive=" + isRadioactive +
                ", isHarmful=" + isHarmful +
                ", wagonType=" + wagonType +
                '}';
    }

    @Override
    public WagonType getWagonType() {
        return wagonType;
    }
}
