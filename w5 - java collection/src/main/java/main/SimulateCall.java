package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bpo.BpoConstantsEnum;
import bpo.Call;
import bpo.CallHandler;

public class SimulateCall {
    public static void main(final String[] args) {
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	final CallHandler handler = (CallHandler) context.getBean("CallHandler");
	final Call call = (Call) context.getBean("Call");
	call.setStatus(BpoConstantsEnum.OPEN.getMessage());
	call.setComplexity(BpoConstantsEnum.PROJECT_MGR_COMPLEXITY.toString());
	handler.handleCall(call, handler.getMax_duration().intValue());
	System.out.println(call);
    }
}
