package bean;

import utill.FileUtility;

import java.io.Serializable;

public class Config implements Serializable {

    private static Config config = null;
    private Student[] students = new Student[0];
    private Teacher[] teachers = new Teacher[0];
    private static boolean loggedIn;

    public static void initialize() {
       Object object = FileUtility.readObjectFile("base.obj");
       if(object == null){
           return;
       }
       if(object instanceof Config){
           config = (Config) object;
       }
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Config.loggedIn = loggedIn;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public static Config getInstance(){
        if(config == null){
             config = new Config();
        }
        return config;
    }
    public void appendStudent(Student student){
        Student[] newStudents = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++){
            newStudents[i] = students[i];
        }
        newStudents[newStudents.length - 1] = student;
        students = newStudents;
    }
    public void appendTeacher(Teacher teacher){
        Teacher[] newTeachers = new Teacher[teachers.length + 1];

        for (int i = 0; i < teachers.length; i++){
            newTeachers[i] = teachers[i];
        }
        newTeachers[newTeachers.length - 1] = teacher;
        teachers = newTeachers;
    }
}
