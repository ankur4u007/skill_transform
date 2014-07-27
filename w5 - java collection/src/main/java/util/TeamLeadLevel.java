package bpo;

import java.util.Random;

public class TeamLeadLevel implements ICallHandler {
    private int id;
    private String status;
    private ICallHandler reportingProjectManager;

    public String handleCall(final Call call, final int duration) {
	call.setCurrentHandler(this);
	if (BpoConstantsEnum.FREE.toString().equals(status)) {
	    status = BpoConstantsEnum.BUSY.toString();
	    if (BpoConstantsEnum.TEAMLEAD_COMPLEXITY.toString().equals(call.getComplexity())) {
		call.setStatus(String.format(BpoConstantsEnum.INPROGRESS.getMessage(), new Object[] { call
		    .getCurrentHandler().getClass().getSimpleName()
		    + " - " + id }));
		call.setDuration(new Random().nextInt(duration - call.getDuration()));
		call.setStatus(String.format(BpoConstantsEnum.HANDLED.getMessage(), new Object[] { call
		    .getCurrentHandler().getClass().getSimpleName()
		    + " - " + id }));
		status = BpoConstantsEnum.FREE.toString();

		return String.format(BpoConstantsEnum.CLOSED.getMessage(), new Object[] { call.getCurrentHandler()
		    .getClass().getSimpleName()
		    + " - " + id });
	    }
	}
	call.setStatus(String.format(BpoConstantsEnum.FORWARDING.getMessage(), new Object[] { reportingProjectManager
	    .getClass().getSimpleName() + " - " + id }));
	status = BpoConstantsEnum.FREE.toString();

	return reportingProjectManager.handleCall(call, duration);
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

    public final ICallHandler getReportingProjectManager() {
	return reportingProjectManager;
    }

    public final void setReportingProjectManager(final ICallHandler reportingProjectManager) {
	this.reportingProjectManager = reportingProjectManager;
    }
}
