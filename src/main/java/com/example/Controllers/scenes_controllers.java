package com.example.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class scenes_controllers {

    ManagementSystem managementSystem = new ManagementSystem();

    public scenes_controllers() throws IOException {
    }

    @FXML
    public void initialize() {
        initializeColumns();
        initializeTeachersColumns();
        btnAgregar.setOnAction(event -> createStudent());
        updateButton.setOnAction(event -> updateStudent());
        updateTeacherButton.setOnAction(event -> updateTeacher());
        courseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        onLoadCourses();

    }

    @FXML
    public void handleMyClassesAction() {
        showAlert("Gestion clases", "Aca se podran gestionar las clases.");
    }

    @FXML
    public void handleTeachersAction() {
        showAlert("Gestion profesores", "Aca se podran gestionar los profesores.");
    }

    @FXML
    public void handleEvaluationsAndProgressAction() {
        showAlert("Gestion evaluaciones y progreso", "Aca se podran gestionar las evaluaciones y progreso.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add((getClass().getResource("styles.css")).toExternalForm()); // Añadir estilos
        dialogPane.setStyle("-fx-background-color: #bde0fe;"); // Cambiar el fondo del alert

        alert.showAndWait();

    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/MAIN_MENU.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 453, 295);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToShowStudents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/students_view_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 780, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToStudentsMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/students_menu_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 257);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToCreateStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/add_student_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToUpdateStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/update_student_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToDeleteStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/delete_student_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToSearchStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/students_scenes/search_student_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToStudentFound(ActionEvent event, Student foundStudent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/scenes/students_scenes/student_found_scene.fxml"));
            Parent root = loader.load();

           scenes_controllers showStudent = loader.getController();
           showStudent.setStudent(foundStudent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToTeachersMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/teachers_menu_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 257);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToCreateTeacher(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/add_teacher_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToShowTeachers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/teachers_list_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 780, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToDeleteTeacher(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/delete_teacher_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 408, 350);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToUpdateTeacher(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/update_teacher_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 408, 350);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSearchTeacher(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/teachers_scenes/search_teacher_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToTeacherFound(ActionEvent event, Teacher foundTeacher) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/scenes/teachers_scenes/teacher_found_scene.fxml"));
            Parent root = loader.load();

            scenes_controllers showTeacher = loader.getController();
            showTeacher.setTeacher(foundTeacher);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 350);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToCoursesMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/courses_scenes/courses_menu_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 408, 257);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToShowCourses(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/courses_scenes/show_courses_scene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 594, 410);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la escena.");
        }
    }

    @FXML
    public void switchToDeleteCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/courses_scenes/delete_course_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 408, 350);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSearchCourse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/courses_scenes/search_course_scene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 408, 350);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox<String> levelComboBox;
    @FXML
    private Button btnAgregar = new Button();
    @FXML
    private Label mensajeLabel;

    @FXML
    private void createStudent() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String dni = dniField.getText().trim();
        String email = emailField.getText().trim();
        String levelStr = levelComboBox.getValue();

        if(managementSystem.doesDniExist("students.json", dni)) {
            mensajeLabel.setText("El DNI ya existe. Por favor, ingrese uno diferente.");
            return;
        }

        if (!email.contains("@") && !email.contains(".")) {
            mensajeLabel.setText("Ingrese un email valido");
            return;
        }

        if (levelStr == null) {
            mensajeLabel.setText("Por favor, seleccione un nivel.");
            return;
        }

        try {
            Level level = Level.valueOf(levelStr.toUpperCase());
            Student student = new Student(firstName, lastName, dni, email, level);
            managementSystem.addStudent(student);
            mensajeLabel.setText("Estudiante creado: " + firstName.toUpperCase() + " " + lastName.toUpperCase());
        } catch (IllegalArgumentException e) {
            mensajeLabel.setText("Nivel inválido. Use: PRINCIPIANTE, INTERMEDIO o AVANZADO.");
        } catch (Exception e) {
            mensajeLabel.setText("Error al agregar el estudiante: " + e.getMessage().toUpperCase());
        }
    }

    @FXML
    private TableView<Student> tableView = new TableView<>();
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    @FXML
    private TableColumn<Student, String> dniColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> levelColumn;

    @FXML
    ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initializeColumns() {

        try{
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            dniColumn.setCellValueFactory(new PropertyValueFactory<>("dni"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

            JsonReader jsonReader = new JsonReader();
            List<Student> students = jsonReader.readJsonFile("students.json");

            if (students != null) {
                studentList = FXCollections.observableArrayList(students);
                tableView.setItems(studentList);
            } else {
                System.err.println("Error al cargar los estudiantes desde el archivo JSON.");
            }

        }catch (NullPointerException _){
            ///SILENCIAMOS LA EXEPCION PORQUE A PESAR DE LANZARSE, TODAS LAS COLUMNAS SE CARGAN IGUALMENTE
        }

    }

    @FXML
    private TextField nameField;
    @FXML
    private Label statusLabel;
    @FXML
    private Button updateButton = new Button();

    @FXML
    private void updateStudent() {
        String dni = dniField.getText().trim();

        Student student = managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (student == null) {
            statusLabel.setText("Estudiante no encontrado.");
            return;
        }

        String newName = nameField.getText().trim();
        if (!newName.isEmpty()) student.setName(newName);

        String newLastName = lastNameField.getText().trim();
        if (!newLastName.isEmpty()) student.setLastName(newLastName);

        String newEmail = emailField.getText().trim();
        if (!newEmail.isEmpty()) student.setEmail(newEmail);

        managementSystem.saveData();

        statusLabel.setText("Estudiante actualizado.");
    }
    @FXML
    private void deleteStudent() {
        String dni = dniField.getText().trim();
        Student student = managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (student == null) {
            statusLabel.setText("Estudiante no encontrado.");
            return;
        }

        managementSystem.getStudents().remove(student);
        managementSystem.saveData();
        statusLabel.setText("Estudiante eliminado.");
        dniField.clear();
    }

    private Student student;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label dniLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label levelLabel;

    @FXML
    public void searchStudent(ActionEvent event) {
        String dni = dniField.getText().trim();
        Student foundStudent = managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);

        if (foundStudent != null) {
            switchToStudentFound(event, foundStudent);
        } else {
            statusLabel.setText("Estudiante no encontrado.");
        }
    }

    public void setStudent(Student student) {
        this.student = student;
        displayStudentInfo();
    }

    private void displayStudentInfo() {
        if (student != null) {
            firstNameLabel.setText("Nombre: " + student.getName());
            lastNameLabel.setText("Apellido: " + student.getLastName());
            dniLabel.setText("DNI: " + student.getDni());
            emailLabel.setText("Email: " + student.getEmail());
            levelLabel.setText("Nivel: " + student.getLevel());
        }
    }

    @FXML
    private ComboBox<String> specialityComboBox;

    @FXML
    private void createProfessor() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String dni = dniField.getText().trim();
        String email = emailField.getText().trim();
        String specialityStr = specialityComboBox.getValue();

        if(managementSystem.doesDniExist("teachers.json", dni)) {
            mensajeLabel.setText("El DNI ya existe. Por favor, ingrese uno diferente.");
            return;
        }

        if (!email.contains("@") && !email.contains(".")) {
            mensajeLabel.setText("Ingrese un email valido");
            return;
        }

        if (specialityStr == null) {
            mensajeLabel.setText("Por favor, seleccione un nivel.");
            return;
        }
        try {
            TypeSpeciality speciality = TypeSpeciality.valueOf(specialityStr.toUpperCase());
            Teacher professor = new Teacher(firstName, lastName, dni, email, speciality);
            managementSystem.addTeacher(professor);
            mensajeLabel.setText("Profesor creado: " + firstName.toUpperCase() + " " + lastName.toUpperCase());
        } catch (IllegalArgumentException e) {
            mensajeLabel.setText("Especialidad inválida. Asegúrese de que esté correctamente definida.");
        } catch (Exception e) {
            mensajeLabel.setText("Error al agregar el profesor: " + e.getMessage().toUpperCase());
        }
    }

    @FXML
    private TableView<Teacher> tableViewTeachers = new TableView<>();
    @FXML
    private TableColumn<Teacher, String> TidColumn;
    @FXML
    private TableColumn<Teacher, String> TnameColumn;
    @FXML
    private TableColumn<Teacher, String> TlastNameColumn;
    @FXML
    private TableColumn<Teacher, String> TdniColumn;
    @FXML
    private TableColumn<Teacher, String> TemailColumn;
    @FXML
    private TableColumn<Teacher, String> typeSpecialityColumn;

    ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

    @FXML
    public void initializeTeachersColumns() {
        try {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            dniColumn.setCellValueFactory(new PropertyValueFactory<>("dni"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            typeSpecialityColumn.setCellValueFactory(new PropertyValueFactory<>("speciality"));

            JsonReader jsonReader = new JsonReader();
            List<Teacher> teachers = jsonReader.readJsonFileTeacher("teachers.json");

            if (teachers != null) {
                teacherList = FXCollections.observableArrayList(teachers);
                tableViewTeachers.setItems(teacherList);
            } else {
                System.err.println("Error al cargar los profesores desde el archivo JSON.");
            }

        } catch (NullPointerException _) {
            // Silenciar excepción porque las columnas se cargan igualmente
        }
    }

    @FXML
    private Button updateTeacherButton = new Button();

    @FXML
    private void updateTeacher() {
        String dni = dniField.getText().trim();


        Teacher teacher = managementSystem.getTeachers().stream()
                .filter(t -> t.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            statusLabel.setText("Profesor no encontrado.");
            return;
        }


        String newName = nameField.getText().trim();
        if (!newName.isEmpty()) teacher.setName(newName);


        String newLastName = lastNameField.getText().trim();
        if (!newLastName.isEmpty()) teacher.setLastName(newLastName);


        String newEmail = emailField.getText().trim();
        if (!newEmail.isEmpty()) teacher.setEmail(newEmail);


        managementSystem.saveData();

        statusLabel.setText("Profesor actualizado.");
    }

    @FXML
    private void deleteTeacher() {
        String dni = dniField.getText().trim();
        Teacher teacher = managementSystem.getTeachers().stream()
                .filter(t -> t.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            statusLabel.setText("Profesor no encontrado.");
            return;
        }

        managementSystem.getTeachers().remove(teacher);
        managementSystem.saveData();
        statusLabel.setText("Profesor eliminado.");
        dniField.clear();
    }

    private Teacher teacher;

    @FXML
    private Label specialityLabel;

    @FXML
    public void searchTeacher(ActionEvent event) {
        String dni = dniField.getText().trim();
        Teacher foundTeacher = managementSystem.getTeachers().stream()
                .filter(t -> t.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);


        if (foundTeacher != null) {
            switchToTeacherFound(event, foundTeacher);
        } else {
            statusLabel.setText("Profesor no encontrado.");
        }
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
        displayTeacherInfo();
    }

    private void displayTeacherInfo() {
        if (teacher != null) {
            firstNameLabel.setText("Nombre: " + teacher.getName());
            lastNameLabel.setText("Apellido: " + teacher.getLastName());
            dniLabel.setText("DNI: " + teacher.getDni());
            emailLabel.setText("Email: " + teacher.getEmail());
            specialityLabel.setText("Especialidad: " + teacher.getSpeciality());
        }
    }

    @FXML
    private ListView<Course> courseListView = new ListView<>();

    @FXML
    private void onLoadCourses() {
        List<Course> courses = managementSystem.getCourses();
        courseListView.getItems().setAll(courses);

        courseListView.setCellFactory(listView -> new ListCell<Course>() {
            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);
                if (empty || course == null) {
                    setText(null);
                } else {
                    setText(course.getName() + " (" + course.getLevel() + ")");
                }
            }
        });

        courseListView.setOnMouseClicked(event -> {
            Course selectedCourse = courseListView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                openCourseDetailsWindow(selectedCourse);
            }
        });
    }

    @FXML
    private ListView<Clase> classesListView = new ListView<>();

    public void setCourse(Course course) {
        classesListView.getItems().setAll(course.getClases());
        ObservableList<Student> enrolledStudents = FXCollections.observableArrayList(course.getEnrolledStudents());
        tableViewStudents.setItems(enrolledStudents);
    }

    @FXML
    private TableView<Student> tableViewStudents = new TableView<>();

    private void openCourseDetailsWindow(Course course) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/scenes/courses_scenes/course_details_scene.fxml"));
            Parent root = loader.load();

            scenes_controllers controller = loader.getController();
            controller.setCourse(course);

            Stage stage = new Stage();
            stage.setTitle("Detalles del Curso: " + course.getName());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Label messageLabel;


    @FXML
    private void handleDeleteCourse() {
        int selectedIndex = courseListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex < 0) {
            messageLabel.setText("Seleccione un curso para eliminar.");
            return;
        }

        managementSystem.getCourses().remove(selectedIndex);
        managementSystem.saveData();
        messageLabel.setText("Curso eliminado con éxito.");
    }

    @FXML
    private TextField searchField;


    @FXML
    private void handleSearchCourse() {
        List<Course> courses = managementSystem.getCourses();
        courseListView.getItems().setAll(courses);

        String searchText = searchField.getText().trim().toLowerCase();

        if (searchText.isEmpty()) {
            messageLabel.setText("Por favor, ingrese un nombre de curso para buscar.");
            return;
        }

        List<Course> searchResults = new ArrayList<>();

        ObservableList<Course> allCourses = courseListView.getItems();

        for (Course course : allCourses) {
            if (course.getName().toLowerCase().contains(searchText)) {
                searchResults.add(course);
            }
        }

        if (searchResults.isEmpty()) {
            messageLabel.setText("No se encontraron resultados.");
            courseListView.setItems(FXCollections.observableArrayList());
        } else {
            courseListView.setItems(FXCollections.observableArrayList(searchResults));
            messageLabel.setText("");
        }
    }


}






