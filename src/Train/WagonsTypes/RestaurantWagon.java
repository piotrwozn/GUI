package Train.WagonsTypes;

public class RestaurantWagon extends Wagon{
    private final int tableCount;
    private final String foodType;
    private final WagonType wagonType;

    public RestaurantWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int tableCount, String foodType) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.tableCount = tableCount;
        this.foodType = foodType;
        this.wagonType = WagonType.RestaurantWagon;
    }

    @Override
    public String toString() {
        return "RestaurantWagon{" +
                "tableCount=" + tableCount +
                ", foodType='" + foodType + '\'' +
                ", wagonType=" + wagonType +
                '}';
    }

    public WagonType getWagonType() {
        return wagonType;
    }
}
