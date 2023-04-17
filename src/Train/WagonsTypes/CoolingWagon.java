package Train.WagonsTypes;

public class CoolingWagon extends BasicFreightWagon{
     private final int minTemperature;
     private final int maxTemperature;
     private final WagonType wagonType;

    public CoolingWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int doorsCount, int handleCount, int minTemperature, int maxTemperature) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec, doorsCount, handleCount);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.wagonType = WagonType.CoolingWagon;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    @Override
    public String toString() {
        return "CoolingWagon{" +
                "minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", wagonType=" + wagonType +
                '}';
    }
}
