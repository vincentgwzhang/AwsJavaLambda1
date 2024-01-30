package study.lambda.start;

public class HelloLambda {

    public String handleRequest(Student student) {
        return "Hello, %s %s".formatted(student.getLastName(), student.getFirstName());
    }

}
