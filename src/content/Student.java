package content;

public class Student {
    
    private int id;
    private int[] grade;
    private String[] course;

    public Student(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getGrade() {
        return grade;
    }

    public void setGrade(int[] grade) {
        this.grade = grade;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }
    
    public int getAvgOfAllGrade(){
        int totalGrade = 0;
        for (int i : this.grade){
            totalGrade += i;
        }
        return totalGrade /(this.grade.length);
    }
    
    
    

}
