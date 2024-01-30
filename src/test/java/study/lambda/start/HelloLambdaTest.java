package study.lambda.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloLambdaTest {

    @Test
    void testHelloLambda() {
        Student student = new Student("Vincent", "Zhang");
        var sut = new HelloLambda();
        assertEquals("Hello, Vincent Zhang", sut.handleRequest(student));
    }
  
}