package jung.demo.studykolininaction.ch5;

import jung.demo.studykolininaction.ch6.JavaRunSomething;
import org.junit.jupiter.api.Test;

public class JavaLambdaTest {


    @Test
    void java_lambda_test() {

        int baseNumber = 0;

        JavaRunSomething runSomething = new JavaRunSomething() {

            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };

    }
}
