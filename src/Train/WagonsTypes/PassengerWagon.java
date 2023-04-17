package Train.WagonsTypes;

public class PassengerWagon extends Wagon{
    private final int compartment;
    private final int wagonClass;
    private final WagonType wagonType;

    public PassengerWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int compartment, int wagonClass) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.compartment = compartment;
        this.wagonClass = wagonClass;
        this.wagonType = WagonType.PassengerWagon;
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "compartment=" + compartment +
                ", wagonClass=" + wagonClass +
                ", wagonType=" + wagonType +
                '}';
    }

    public WagonType getWagonType() {
        return wagonType;
    }
}
