package Entities;

import java.io.Serializable;

public class Plan implements Serializable {

    private boolean exists;
    private PlanofDay[] plan;
    private int[] days;


    public Plan() {
        this.plan = new PlanofDay[8];
        this.exists = false;
    }

    public PlanofDay getPlanofDay(int day) {
        return plan[day];
    }

    public void setPlanofDay(PlanofDay planofDay, int day) {
        this.plan[day] = planofDay;
    }

    public int[] getDays() {
        return days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    public void setExistance() {
        this.exists = true;
    }

    public boolean planExists() {
        return exists;
    }
}
