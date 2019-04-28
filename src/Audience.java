public class Audience {
    private int audienceId;
    private int audienceNumber;
    private int capacity;

    Audience(int audienceId, int audienceNumber, int capacity){
        this.audienceId = audienceId;
        this.audienceNumber = audienceNumber;
        this.capacity = capacity;
    }

    public int getAudienceId(){
        return this.audienceId;
    }

    public int getAudienceNumber(){
        return this.audienceNumber;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
