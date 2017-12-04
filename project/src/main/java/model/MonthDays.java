package model;

public class MonthDays {
    private String day;
    private boolean hasEvent;

    public MonthDays(String day, boolean hasEvent) {
        this.day = day;
        this.hasEvent = hasEvent;
    }
    
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public boolean isHasEvent() {
        return hasEvent;
    }
    public void setHasEvent(boolean hasEvent) {
        this.hasEvent = hasEvent;
    }
}
