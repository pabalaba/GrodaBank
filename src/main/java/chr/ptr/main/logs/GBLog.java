package chr.ptr.main.logs;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.math.BigDecimal;

public class GBLog {

    private GBLAction action;
    private BigDecimal value;
    private String sender;
    private String receiver;

    public GBLog(GBLAction action, BigDecimal value, String sender, String receiver) {
        this.action = action;
        this.value = value;
        this.sender = sender;
        this.receiver = receiver;
    }

    public GBLAction getAction() {
        return action;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GBLog{");
        sb.append("action=").append(action);
        sb.append(", value=").append(value);
        sb.append(", sender='").append(sender).append('\'');
        sb.append(", receiver='").append(receiver).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
