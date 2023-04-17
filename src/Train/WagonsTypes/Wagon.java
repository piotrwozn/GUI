package Train.WagonsTypes;

import java.util.Random;

public abstract class Wagon {

    private String sender;
    private String security;
    private double netWeight;
    private double grossWeight;
    private int numSeats;
    private long id;
    private boolean needElec;
    private boolean isLoaded;

    public Wagon(String sender, String security, double netWeight, double grossWeight, int numSeats, boolean needElec) {
        this.sender = sender;
        this.security = security;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.numSeats = numSeats;
        this.id = generateID(id);
        this.needElec = needElec;
        this.isLoaded = false;
    }

    private long generateID(long id){
        long uniqueID = System.currentTimeMillis() + new Random().nextInt(9999);
        id = uniqueID;

        return id;
    }

    public double getWeight() {
        if(isLoaded) {
            return grossWeight;
        } else {
            return netWeight;
        }
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Wagon :" + "\n" +
                "sender='" + sender + '\n' +
                "security='" + security + '\n' +
                "weight=" + this.getWeight() + "\n" +
                "numSeats=" + numSeats + "\n" +
                "id=" + id;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public boolean isNeedElec() {
        return needElec;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
