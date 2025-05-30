import java.util.*;

class Student{
    private int studentid;
    private String name;
    private int daysattended;

    Student(int studentid, String name , int daysattended){
        this.studentid = studentid;
        this.name = name;
        this.daysattended = daysattended;
    }

    public int getStudentid(){
        return studentid;
    }
    public void setstudentid(int studentid){
        this.studentid = studentid;
    }
    public String getName(){
        return name;
    }
    public void setname(String name){
        this.name= name;
    }
    public int getDaysattended(){
        return daysattended;
    }
    public void setdaysattended(int daysattended){
        this.daysattended = daysattended;
    }

     public void display() {
        System.out.println(studentid + "\t" + name + "\t" + daysattended);
    }

}

class Classroom{

    Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> studentidarr = new ArrayList<>(10);
    static ArrayList<String> studentnamearr = new ArrayList<>(10);
    static ArrayList<Integer> studentdaysarr = new ArrayList<>(10);

    int numberofStudents = 0;

    void addnewstudent(){
        for(int i =0 ; i<3 ;i++){
            System.out.println("-------add new Student--------");
            System.out.println("enter student id");
            studentidarr.add(sc.nextInt());
            
            sc.nextLine();
            System.out.println("enter student name");
            studentnamearr.add(sc.nextLine());

            System.out.println("enter student days of attend");
            studentdaysarr.add(sc.nextInt());

            numberofStudents++;
        }
    }

    int userInput;
    int correctdays;

    void editattendence(){
            System.out.println("enter the id of student you want to edit");
            userInput=sc.nextInt();
          
            if(userInput == 101){
                System.out.println("enter new days");
                correctdays = sc.nextInt();
                studentdaysarr.set(0,correctdays);
            }
            else if(userInput == 102){
                System.out.println("enter new days");
                correctdays = sc.nextInt();
                studentdaysarr.set(1,correctdays);
            }
            else if(userInput == 103){
                System.out.println("enter new days");
                correctdays = sc.nextInt();
                studentdaysarr.set(2,correctdays);
            }      
            else{
                System.out.println("invalid Id");
            }    
        
    }
    
    public static void main(String[] args){
        Classroom obj = new Classroom();

        obj.addnewstudent();
        obj.editattendence();
        
        Student gt = new Student(studentidarr.get(0),studentnamearr.get(0),studentdaysarr.get(0));
        Student gt1 = new Student(studentidarr.get(1),studentnamearr.get(1),studentdaysarr.get(1));
        Student gt2 = new Student(studentidarr.get(2),studentnamearr.get(2),studentdaysarr.get(2));

        System.out.println("####### Table of attendence ########");
        System.out.println("id\t name\t attend days");
        System.out.println(gt.getStudentid()+"\t"+gt.getName()+"\t"+gt.getDaysattended());
        System.out.println(gt1.getStudentid()+"\t"+gt1.getName()+"\t"+gt1.getDaysattended());
        System.out.println(gt2.getStudentid()+"\t"+gt2.getName()+"\t"+gt2.getDaysattended());
    }
}
