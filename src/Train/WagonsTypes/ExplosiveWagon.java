package Train.WagonsTypes;

public class ExplosiveWagon extends HeavyFreightWagon{
    private final String explosivesType;
    private final boolean isDangerous;
    private final WagonType wagonType;

    public ExplosiveWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, String additionalDevices, String adaptation, String explosivesType, boolean isDangerous) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, additionalDevices, adaptation);
        this.explosivesType = explosivesType;
        this.isDangerous = isDangerous;
        this.wagonType = WagonType.ExplosiveWagon;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    @Override
    public String toString() {
        return "ExplosiveWagon{" +
                "explosivesType='" + explosivesType + '\'' +
                ", isDangerous=" + isDangerous +
                ", wagonType=" + wagonType +
                '}';
    }
}
