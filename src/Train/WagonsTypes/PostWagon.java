package Train.WagonsTypes;

public class PostWagon extends Wagon{
    private final int postBoxCount;
    private final int maxLetterCount;
    private final WagonType wagonType;

    public PostWagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec, int postBoxCount, int maxLetterCount) {
        super(sender, security, netWeight, grossWeight, numSeats, needElec);
        this.postBoxCount = postBoxCount;
        this.maxLetterCount = maxLetterCount;
        this.wagonType = WagonType.PostWagon;
    }

    @Override
    public String toString() {
        return "PostWagon{" +
                "postBoxCount=" + postBoxCount +
                ", maxLetterCount=" + maxLetterCount +
                ", wagonType=" + wagonType +
                '}';
    }

    public WagonType getWagonType() {
        return wagonType;
    }
}
