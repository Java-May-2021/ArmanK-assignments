public class IPhone extends Phone implements Ringable{
     public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring(){
        return getRingTone();
    }
    @Override
    public String unlock(){
        return "Its Unlocked Yeah";
    }
    
    public void displayInfo() {
        System.out.println(getVersionNumber()+" from "+getCarrier());       
    }
}