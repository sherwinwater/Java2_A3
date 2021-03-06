/**
 * Shuwen Wang
 * 991583096
 * Assignment 2
 * 02-05-2020
 */
package view;

import content.Student;
import java.io.BufferedWriter;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import studentfx.Studentfx;

public class DisplayStage extends Stage {

    private ArrayList<Student> studentList = new ArrayList<>();
    private String[] lblContents = {
        "Student's overall average of all courses:\n",
        "Overall average of each course:\n",
        "Overall average of all students:"};

    public DisplayStage(ArrayList<Student> studentList) {
        this.studentList = studentList;
        setScene(addScene());
    }

    public Scene addScene() {
        VBox pane = new VBox(5);

        Label lblStudentGrade = new Label(lblContents[0]);
        Label lblCourseGrade = new Label(lblContents[1]);
        Label lblOverallAvgGrade = new Label(lblContents[2]);

        TextArea txaStudentGrade = new TextArea(getGradeResults()[0]);
        TextArea txaCourseGrade = new TextArea(getGradeResults()[1]);
        TextArea txaOverallAvgGrade = new TextArea(getGradeResults()[2]);
        txaStudentGrade.setPrefRowCount(5);
        txaStudentGrade.setScrollTop(5);
        txaCourseGrade.setPrefRowCount(4);
        txaOverallAvgGrade.setPrefRowCount(1);

        Button btnReturnHome = new Button("Return home and add grades");
        Button btnSaveFile = new Button("Save results");
        btnSaveFile.setTextFill(Color.DARKRED);
        btnReturnHome.setTextFill(Color.DARKBLUE);

        pane.getChildren().addAll(lblStudentGrade, txaStudentGrade,
                lblCourseGrade, txaCourseGrade, lblOverallAvgGrade,
                txaOverallAvgGrade, btnSaveFile, btnReturnHome);

        btnReturnHome.setOnAction((e) -> {
            ((Stage) (this.getScene().getWindow())).close();
            Studentfx.primaryStage.show();

        });
        btnSaveFile.setOnAction((e) -> {
            saveFile();
        });

        Scene one = new Scene(pane, 350, 400);
        return one;
    }

    public String[] getGradeResults() {
        int studentListSize = this.studentList.size();
        String studentGrade = new String();
        String courseGrade = new String();
        String overallAvgGrade = new String();

        if (studentListSize > 0) {
            int[] grades = new int[5];
            String[] courses = new String[5];
            int gradeAllAvg = 0;

            // retrieve student data from ArrayList passed from the main class
            for (int sub = 0; sub < studentListSize; sub++) {
                Student one = this.studentList.get(sub);
                studentGrade += "Student ID " + one.getId() + " : " + one.getAvgOfAllGrade() + "\n";
                gradeAllAvg += one.getAvgOfAllGrade() / studentListSize;
                for (int i = 0; i < 5; i++) {
                    grades[i] += one.getGrades()[i] / studentListSize;
                    courses[i] = one.getCourses()[i];
                }
            }
            for (int i = 0; i < 5; i++) {
                courseGrade += courses[i] + " : " + grades[i] + "\n";
            }
            overallAvgGrade = gradeAllAvg + "\n";
        }
        String[] gradeResults = {studentGrade, courseGrade, overallAvgGrade};

        return gradeResults;
    }

    private void saveFile() {
        try {
            FileWriter fw = new FileWriter("courseGrades.dat", false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int sub = 0; sub < this.studentList.size(); sub++) {
                Student one = this.studentList.get(sub);
                String id = String.valueOf(one.getId());
                String grades = new String();
                for (int i = 0; i < one.getGrades().length; i++) {
                    grades += "," + one.getGrades()[i];
                }
                String sData = id + grades;
                bw.write(sData);
                bw.flush();
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("no data found");
        }
    }
}
