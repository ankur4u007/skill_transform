package bpo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("CallHandler")
public class CallHandler implements ICallHandler {
    @Resource(name = "createEmployees")
    private List<ICallHandler> fresherList;
    @Value("${call_duration_limit}")
    private Integer max_duration;

    public String handleCall(final Call call, final int duration) {
	String response = null;
	for (final ICallHandler fresher : fresherList) {
	    response = fresher.handleCall(call, duration);
	    if (!BpoConstantsEnum.BUSY.toString().equals(response)) {
		break;
	    }
	}
	return response;
    }

    public final Integer getMax_duration() {
	return max_duration;
    }
}
