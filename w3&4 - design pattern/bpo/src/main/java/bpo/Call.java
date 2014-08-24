package bpo;

import org.springframework.stereotype.Component;

@Component("Call")
public class Call {
    private String status;
    private int duration;
    private String complexity;
    private ICallHandler currentHandler;

    public final String getStatus() {
	return status;
    }

    public final void setStatus(final String status) {
	this.status = status;
	System.out.println(this.status);
    }

    public final int getDuration() {
	return duration;
    }

    public final void setDuration(final int duration) {
	this.duration = duration;
    }

    public final ICallHandler getCurrentHandler() {
	return currentHandler;
    }

    public final void setCurrentHandler(final ICallHandler currentHandler) {
	this.currentHandler = currentHandler;
    }

    public final String getComplexity() {
	return complexity;
    }

    public final void setComplexity(final String complexity) {
	this.complexity = complexity;
    }

    @Override
    public String toString() {
	return "Call [status=" + status + ", duration=" + duration + " hours, complexity=" + complexity
		+ ", LastHandler=" + currentHandler.getClass().getSimpleName() + "]";
    }
}
