/**
 * Shuwen Wang
 * 991583096
 * Assignment 2
 * 02-05-2020
 */
package content;

public class Student {
    
    private int id;
    private int[] grades;
    private String[] courses;

    public Student(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public int getAvgOfAllGrade(){
        int totalGrade = 0;
        for (int i : this.grades){
            totalGrade += i;
        }
        return totalGrade /(this.grades.length);
    }
    
    
    

}
