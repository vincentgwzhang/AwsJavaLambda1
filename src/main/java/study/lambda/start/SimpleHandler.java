package study.lambda.start;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleHandler implements RequestHandler<Student, String> {

    @Override
    public String handleRequest(Student input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("getAwsRequestId:" + context.getAwsRequestId());
        logger.log("getLogGroupName:" + context.getLogGroupName());
        logger.log("getFunctionName:" + context.getFunctionName());
        logger.log("getFunctionVersion:" + context.getFunctionVersion());
        logger.log("getInvokedFunctionArn:" + context.getInvokedFunctionArn());
        logger.log("getRemainingTimeInMillis:" + context.getRemainingTimeInMillis());
        logger.log("getMemoryLimitInMB:" + context.getMemoryLimitInMB());
        return new HelloLambda().handleRequest(input);
    }
}
