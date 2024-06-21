package com.example.studentmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> studentIdColumn;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, String> studentEmailColumn;
    @FXML
    private TableColumn<Student, String> studentMajorColumn;

    @FXML
    private TextField studentIdField;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField studentEmailField;
    @FXML
    private TextField studentMajorField;

    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Student> studentList;

    @FXML
    private void initialize() {
        studentList = FXCollections.observableArrayList();
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentMajorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        studentTable.setItems(studentList);
        addButton.setOnAction(event -> addStudent());
        updateButton.setOnAction(event -> updateStudent());
        deleteButton.setOnAction(event -> deleteStudent());
    }

    private void addStudent() {
        int id = Integer.parseInt(studentIdField.getText());
        String name = studentNameField.getText();
        String email = studentEmailField.getText();
        String major = studentMajorField.getText();
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setMajor(major);
        studentList.add(student);
        clearFields();
    }

    private void updateStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            selectedStudent.setId(Integer.parseInt(studentIdField.getText()));
            selectedStudent.setName(studentNameField.getText());
            selectedStudent.setEmail(studentEmailField.getText());
            selectedStudent.setMajor(studentMajorField.getText());
            studentTable.refresh();
            clearFields();
        }
    }

    private void deleteStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
            clearFields();
        }
    }

    private void clearFields() {
        studentIdField.clear();
        studentNameField.clear();
        studentEmailField.clear();
        studentMajorField.clear();
    }
}
