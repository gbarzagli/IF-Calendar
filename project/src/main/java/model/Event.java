package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event extends EntityObject {
    
    public static final String CLASS_NAME = "Event";

    @Column
    private String name;

    @Column
    private String local;

    @Column
    private Date start;

    @Column
    private Date end;
    
    @Column
    private boolean sent;
    
    public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

    @ManyToOne
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
    private Calendar calendar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    
    public String getEventTime() {
        LocalDateTime localDateTimeStart = LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTimeEnd = LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault());
        
        int startHour = localDateTimeStart.getHour();
        int endHour = localDateTimeEnd.getHour();
        int startMinute = localDateTimeStart.getMinute();
        int endMinute = localDateTimeEnd.getMinute();
        
        String startHourStr;
        if (startHour < 10) {
            startHourStr = "0" + Integer.toString(startHour);
        } else {
            startHourStr = Integer.toString(startHour);
        }
        
        String startMinStr;
        if (startMinute < 10) {
            startMinStr = "0" + Integer.toString(startMinute);
        } else {
            startMinStr = Integer.toString(startMinute);
        }
        
        String endHourStr;
        if (endHour < 10) {
            endHourStr = "0" + Integer.toString(endHour);
        } else {
            endHourStr = Integer.toString(endHour);
        }
        
        String endMinStr;
        if (endMinute < 10) {
            endMinStr = "0" + Integer.toString(endMinute);
        } else {
            endMinStr = Integer.toString(endMinute);
        }
        
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(startHourStr + ":" + startMinStr);
        stringBuffer.append(" - ");
        stringBuffer.append(endHourStr + ":" + endMinStr);
        
        String eventTime = stringBuffer.toString();
        return eventTime;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
