package study.lambda.start;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleHandlerTest {

    SimpleHandler simpleHandler = new SimpleHandler();

    @Mock
    private Context context;

    @Mock
    private LambdaLogger logger;

    @BeforeEach
    public void setUp() {
        when(context.getLogger()).thenReturn(logger);

        doAnswer(call -> {
            System.out.println((String) call.getArgument(0));
            return null;
        }).when(logger).log(anyString());

        when(context.getAwsRequestId()).thenReturn("");
        when(context.getLogGroupName()).thenReturn("");
        when(context.getFunctionName()).thenReturn("");
        when(context.getFunctionVersion()).thenReturn("");
        when(context.getInvokedFunctionArn()).thenReturn("");
        when(context.getRemainingTimeInMillis()).thenReturn(0);
        when(context.getMemoryLimitInMB()).thenReturn(0);
    }

    @Test
    void handleRequest() {
        assertEquals("Hello, Vincent Zhang", simpleHandler.handleRequest(new Student("Vincent", "Zhang"), context));
    }
}