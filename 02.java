import java.util.*;

class Vehical{
	private String licenseplate;
    private String ownerName;
    private int hourseParked;

    Vehical(String licenseplate, String ownerName , int hourseParked){
        this.licenseplate = licenseplate;
        this.ownerName = ownerName;
        this.hourseParked =hourseParked;
    }

    public String getLicenseplate(){
        return licenseplate;
    }
    public void setLicenseplate(String licenseplate){
        this.licenseplate = licenseplate;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void  setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public int getHourseParked(){
        return hourseParked;
    }
    public void setHourseParked(int hourseParked){
        this.hourseParked =hourseParked;
    }

}


class ParkingLot {
    Vehical[] vehicles = new Vehical[5];
    int count = 0;

    public void parkVehicle(Vehical v) {
        if (count < 5) {
            vehicles[count] = v;
            count++;
        } else {
            System.out.println("Parking lot is full.");
        }
    }

    public void removeVehicle(String licensePlate) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicenseplate().equals(licensePlate)) {
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                System.out.println("Vehicle with license " + licensePlate + " removed.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void displayVehicles() {
        if (count == 0) {
            System.out.println("No vehicles parked.");
        } else {
            System.out.println("license\t owner\t hours");
            for (int i = 0; i < count; i++) {
                System.out.println(vehicles[i].getLicenseplate()+"\t "+ vehicles[i].getOwnerName() +"\t "+ vehicles[i].getHourseParked());
            }
        }
    }

    public static void main(String[] args) {
        
        ParkingLot lot = new ParkingLot();

        lot.parkVehicle(new Vehical("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehical("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehical("LMN456", "Bob Brown", 1));

        lot.removeVehicle("XYZ789");

        lot.displayVehicles();
    }    
}
