classDiagram
 
    %% --- Entities ---
    class Person {
         -int id 
         -String firstName 
         -String lastName 
         -String email 

         +getDisplayName() 
    } 
    class Student { 
        -String batch 
        -boolean active 
        +Student(firstName, lastName, batch) 
        +getDisplayName() 
    }
    class Course { 
        -int id 
        -String courseName 
        -String description 
        -int durationInWeeks 
        -boolean active 
    }

    class Enrollment { 
        -int id 
        -int studentId 
        -int courseId 
        -LocalDate enrollmentDate 
        -String status 
    }

%% --- Services --- 
class StudentService { 
    -List~Student~ students 

    +addStudent(student) 
    +getStudentById(id) 
    +listStudents()
    +deactivateStudent(id) 
}    
class CourseService {
     -List~Course~ courses 

     +addCourse(course) 
     +getCourseById(id) 
     +listCourses() 
     +toggleCourseStatus(id) 
} 
class EnrollmentService { 
    -List~Enrollment~ enrollments 

    -StudentService studentService 
    -CourseService courseService 

    +enrollStudent(studentId, courseId) 
    +listEnrollmentsForStudent(studentId) }

%% --- Utils & UI --- 
class InputValidator { 
    +getStringInput(prompt) 
    +getIntInput(prompt) 
} 
class IdGenerator { 
    +static int studentIdCounter 
    +static int courseIdCounter 
    +static int enrollmentIdCounter
     
    +static getNextStudentId() 
    +static getNextCourseId() 
    +static getNextEnrollmentId() 
} 
class Main { +main(args) 
    +displayMainMenu() 
}

%% -- inheritance
 Person <|-- Student : extends

%% Service Entity Management (Composition/Aggregation) 
StudentService *-- Student : manages
CourseService *-- Course : manages 
EnrollmentService *-- Enrollment : manages

 %% Service Dependencies 
 EnrollmentService --> StudentService : uses 
 EnrollmentService --> CourseService : uses 

 %% UI Dependencies 
 Main --> StudentService 
 Main --> CourseService 
 Main --> EnrollmentService 
 Main --> InputValidator

 %% Utility Dependencies 
 Student ..> IdGenerator : uses (static) 
 Course ..> IdGenerator : uses (static) 
 Enrollment ..> IdGenerator : uses (static)
