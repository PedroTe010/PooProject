package Entities;

import java.io.Serializable;

public class UserStats implements Serializable {

    private int calories_burnt;
    private int kms_runned;
    private int altimetry_meters;
    private int session_km_record;
    private int session_altimetry_record;
    private int session_calories_record;


    public void UserStatsConstructor() {
        this.calories_burnt = 0;
        this.kms_runned = 0;
        this.altimetry_meters = 0;
        this.session_km_record = 0;
        this.session_altimetry_record = 0;
        this.session_calories_record = 0;
    }

    public int getCalories_burnt() {
        return calories_burnt;
    }

    public void setCalories_burnt(int calories_burnt) {
        this.calories_burnt = getCalories_burnt() + calories_burnt;
    }

    public int getKms_runned() {
        return kms_runned;
    }

    public void setKms_runned(int kms_runned) {
        this.kms_runned = getKms_runned() + kms_runned;
    }

    public int getAltimetry_meters() {
        return altimetry_meters;
    }

    public void setAltimetry_meters(int altimetry_meters) {
        this.altimetry_meters = getAltimetry_meters() + altimetry_meters;
    }

    public int getSession_km_record() {
        return session_km_record;
    }

    public void setSession_km_record(int session_km_record1) {
        if(session_km_record1 > session_km_record) this.session_km_record = session_km_record1;
    }

    public int getSession_altimetry_record() {
        return session_altimetry_record;
    }

    public void setSession_altimetry_record(int session_altimetry_record1) {
        if (session_altimetry_record1 > session_altimetry_record) this.session_altimetry_record = session_altimetry_record1;
    }

    public int getSession_calories_record() {
        return session_calories_record;
    }

    public void setSession_calories_record(int session_calories_record1) {
        if (session_calories_record1 > session_calories_record) this.session_calories_record = session_calories_record1;
    }
}
