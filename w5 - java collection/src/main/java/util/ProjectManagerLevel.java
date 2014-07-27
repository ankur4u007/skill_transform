package bpo;

import java.util.Random;

public class ProjectManagerLevel implements ICallHandler {
    private int id;
    private String status;

    public String handleCall(final Call call, final int duration) {
	call.setCurrentHandler(this);
	if (BpoConstantsEnum.FREE.toString().equals(status)) {
	    status = BpoConstantsEnum.BUSY.toString();
	    if (!BpoConstantsEnum.PROJECT_MGR_COMPLEXITY.toString().equals(call.getComplexity())) {
		call.setStatus(String.format(BpoConstantsEnum.CALL_HANDLING_ERROR.getMessage(), new Object[0]));
		return call.getStatus();
	    }
	}
	call.setStatus(String.format(BpoConstantsEnum.INPROGRESS.getMessage(), new Object[] { call.getCurrentHandler()
	    .getClass().getSimpleName()
	    + " - " + id }));
	call.setDuration(new Random().nextInt(duration - call.getDuration()));
	call.setStatus(String.format(BpoConstantsEnum.HANDLED.getMessage(), new Object[] { call.getCurrentHandler()
	    .getClass().getSimpleName()
	    + " - " + id }));
	status = BpoConstantsEnum.FREE.toString();

	return String.format(BpoConstantsEnum.CLOSED.getMessage(), new Object[] { call.getCurrentHandler().getClass()
	    .getSimpleName()
	    + " - " + id });
    }

    public final void setId(final int id) {
	this.id = id;
    }

    public final String getStatus() {
	return status;
    }

    public final void setStatus(final String status) {
	this.status = status;
    }
}
