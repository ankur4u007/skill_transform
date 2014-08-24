package bpo;

/**
 *
 * @author CHANDRAYAN
 *
 */
public enum BpoConstantsEnum {
    CLOSED("Call Request is Closed by : %1$s"), OPEN("Call Request is Open"), INPROGRESS(
	    "Call Handling is in Progress by %1$s"), FREE("%1$s is free"), BUSY("%1$s is busy"), HANDLED(
		    "Call Request was handled by %1$s"), FORWARDING("Call Request is Being forwarded to %1$s"), FRESHER_COMPLEXITY(
			    "Call request complexity upto fresher level"), TEAMLEAD_COMPLEXITY("Call request complexity upto TL level"), PROJECT_MGR_COMPLEXITY(
				    "Call request complexity upto PM level"), CALL_HANDLING_ERROR("Complexity was not defined properly");

    private String message;

    /**
     *
     * @param message
     */
    private BpoConstantsEnum(final String message) {
	this.message = message;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
	return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(final String message) {
	this.message = message;
    }

    @Override
    public String toString() {
	return name();
    }
}
