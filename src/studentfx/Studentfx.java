/**
 * Shuwen Wang
 * 991583096
 * Assignment 2
 * 02-05-2020
 */
package studentfx;

import content.Student;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.DisplayStage;

public class Studentfx extends Application{

    private Label lblID = new Label("Student ID");
    private Label lblCourseTitle = new Label("Courses");
    private Label lblGradeTitle = new Label("Grades");
    private Label lblCourse1 = new Label("Math");
    private Label lblCourse2 = new Label("English");
    private Label lblCourse3 = new Label("Science");
    private Label lblCourse4 = new Label("History");
    private Label lblCourse5 = new Label("Geography");

    private TextField txtID = new TextField();
    private TextField txtGrade1 = new TextField();
    private TextField txtGrade2 = new TextField();
    private TextField txtGrade3 = new TextField();
    private TextField txtGrade4 = new TextField();
    private TextField txtGrade5 = new TextField();

    private Button btnAddGrade = new Button("Add Grade");
    private Button btnDisplayGrade = new Button("Display Grade");
    private ArrayList<Student> studentList = new ArrayList<>();
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        btnAddGrade.setOnAction((e) -> {
            studentList.add(recordGrade());
        });

        btnDisplayGrade.setOnAction((e) -> {
            DisplayStage ds = new DisplayStage(studentList);
            ds.show();
            this.primaryStage.close();
        });

        Scene scene = new Scene(addPane(), 300, 300);
        primaryStage.setTitle("Student Course Grades");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane addPane() {
        GridPane pane = new GridPane();

        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        pane.add(lblID, 0, 0);
        pane.add(lblCourseTitle, 0, 1);
        pane.add(lblCourse1, 0, 2);
        pane.add(lblCourse2, 0, 3);
        pane.add(lblCourse3, 0, 4);
        pane.add(lblCourse4, 0, 5);
        pane.add(lblCourse5, 0, 6);

        pane.add(txtID, 1, 0);
        pane.add(lblGradeTitle, 1, 1);
        pane.add(txtGrade1, 1, 2);
        pane.add(txtGrade2, 1, 3);
        pane.add(txtGrade3, 1, 4);
        pane.add(txtGrade4, 1, 5);
        pane.add(txtGrade5, 1, 6);

        pane.add(btnAddGrade, 0, 7);
        pane.add(btnDisplayGrade, 1, 7);

        return pane;
    }

    private Student recordGrade() {
        Student one = new Student();

        int id = Integer.parseInt(txtID.getText());
        int grade1 = Integer.parseInt(txtGrade1.getText());
        int grade2 = Integer.parseInt(txtGrade2.getText());
        int grade3 = Integer.parseInt(txtGrade3.getText());
        int grade4 = Integer.parseInt(txtGrade4.getText());
        int grade5 = Integer.parseInt(txtGrade5.getText());

        String course1 = lblCourse1.getText();
        String course2 = lblCourse2.getText();
        String course3 = lblCourse3.getText();
        String course4 = lblCourse4.getText();
        String course5 = lblCourse5.getText();

        int[] grades = {grade1, grade2, grade3, grade4, grade5};
        String[] courses = {course1, course2, course3, course4, course5};

        one.setId(id);
        one.setCourses(courses);
        one.setGrades(grades);

        txtID.clear();
        txtGrade1.clear();
        txtGrade2.clear();
        txtGrade3.clear();
        txtGrade4.clear();
        txtGrade5.clear();
        txtID.requestFocus();
        
        return one;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
