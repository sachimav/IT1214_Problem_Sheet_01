import java.util.Scanner;

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

class Parkinglot{

    Scanner sc = new Scanner(System.in);

    static String[] licenarr = new String[5];
    static String[] ownerarr = new String[5];
    static int[] hoursearr = new int[5];

    static int vehicalcount = 0;

    void parkvehical(){

       int choices; 

       do{

        if (vehicalcount >= 5) {
                System.out.println("Parking lot full.");
                break;
            }
            System.out.println("enter new vehical");
            System.out.println("enter vehical licenplate");
            licenarr[vehicalcount] = sc.nextLine();

            System.out.println("enter ownername");
            ownerarr[vehicalcount] = sc.nextLine();

        
            System.out.println("enter hourse parked");
            hoursearr[vehicalcount] = sc.nextInt();

            vehicalcount++;

            System.out.println("do yoy wnt to add another vehicals yes-0 || no-1");
            choices = sc.nextInt();

            sc.nextLine();

        }while(choices == 0);   

    }

    void removevehi(){

        int Userinput;
        int choice;

        do{
            System.out.println("enter vehical number to remove 0-4");
            choice = sc.nextInt();

            if (choice >= 0 && choice < 5) {
                licenarr[choice] = null;
                ownerarr[choice] = null;
                hoursearr[choice] = 0;

                System.out.println("Vehicle removed.");
            } else {
                System.out.println("Invalid index.");
            }

            System.out.println("do you want to remove more vihicals 0-yes || 1-no");
            Userinput = sc.nextInt();

        }
        while(Userinput == 0);
    }
    public static void main(String[] args){

        Parkinglot obj = new Parkinglot();

        obj.parkvehical();
        obj.removevehi();
        
        System.out.println("\nLicense\t\tOwner\t\tHours Parked");
        for (int i = 0; i < 5; i++) {
            if (licenarr[i] != null) {
                Vehical v = new Vehical(licenarr[i], ownerarr[i], hoursearr[i]);
                System.out.println(v.getLicenseplate() + "\t" + v.getOwnerName() + "\t\t" + v.getHourseParked());
            }
        }
    }    
}