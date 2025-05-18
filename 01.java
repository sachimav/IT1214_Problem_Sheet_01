import java.util.Scanner;

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
    public String getName(){
        return name;
    }
    public int getDaysattended(){
        return daysattended;
    }

}

class Classroom{

    Scanner sc = new Scanner(System.in);

    int[] studentidarr = new int[10];
    String[] studentnamearr = new String[10];
    int[] studentdaysarr = new int[10];

    int numberofStudents = 0;

    void addnewstudent(){
        for(int i =0 ; i<3 ;i++){
            System.out.println("-------add new Student--------");
            System.out.println("enter student id");
            studentidarr[i] = sc.nextInt();
            
            sc.nextLine();
            System.out.println("enter student name");
            studentnamearr[i] = sc.nextLine();

            System.out.println("enter student days of attend");
            studentdaysarr[i] = sc.nextInt();

            numberofStudents++;
        }
    }

    int userInput;
    int correctdays;

    void editattendence(){
            System.out.println("enter the number of student you want to edit 0-2");
            userInput=sc.nextInt();
            
            System.out.println("enter new days");
            correctdays = sc.nextInt();
            try{ 
                studentdaysarr[userInput] = correctdays;
            }
            catch (Exception e) {
                System.out.println("invalid number");
            }    
        
    }
    public static void main(String[] args){
        Classroom obj = new Classroom();

        obj.addnewstudent();
        obj.editattendence();
        
        Student gt = new Student(obj.studentidarr[0],obj.studentnamearr[0],obj.studentdaysarr[0]);
        Student gt1 = new Student(obj.studentidarr[1],obj.studentnamearr[1],obj.studentdaysarr[1]);
        Student gt2 = new Student(obj.studentidarr[2],obj.studentnamearr[2],obj.studentdaysarr[2]);

        System.out.println("####### Table of attendence ########");
        System.out.println("id\t name\t attend days");
        System.out.println(gt.getStudentid()+"\t"+gt.getName()+"\t"+gt.getDaysattended());
        System.out.println(gt1.getStudentid()+"\t"+gt1.getName()+"\t"+gt1.getDaysattended());
        System.out.println(gt2.getStudentid()+"\t"+gt2.getName()+"\t"+gt2.getDaysattended());
    }
}
