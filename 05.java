import java.util.Scanner;

class Student{
	
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	Student(String name,int exam1,int exam2,int exam3){
		
		this.name = name;
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.exam3 = exam3;
		
		if (!isValidScore(exam1) || !isValidScore(exam2) || !isValidScore(exam3)) {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
		
	}
	
	private boolean isValidScore(int score) {
        if(score >= 0 && score <= 100){
			return true;
		}
		else{
			return false;
		}
    }
	
	public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        try {
            Student obj = new Student("John", 75, 100, 90);
            System.out.printf("Average is :"+obj.getName()+" "+obj.calculateAverage());
        } 
		catch (IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
	
}
