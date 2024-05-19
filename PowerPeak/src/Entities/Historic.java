package Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Historic implements Serializable {

    private LocalDate date;
    private ArrayList<Exercise> exercises;
    private PlanofDay planofDay;
    private ArrayList<Integer> total_reps;
    private ArrayList<Integer> time;
    private ArrayList<Integer> kms_only_distance;
    private ArrayList<Integer> kms_altimetry;
    private ArrayList<Integer> calories;
    private int calories_total;
    private ArrayList<Integer> heart_rate;

    public Historic() {
        this.total_reps = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.time = new ArrayList<>();
        this.kms_only_distance = new ArrayList<>();
        this.kms_altimetry = new ArrayList<>();
        this.calories = new ArrayList<>();
        this.heart_rate = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public PlanofDay getPlanofDay() {
        return planofDay;
    }

    public void setPlanofDay(PlanofDay planofDay) {
        this.planofDay = planofDay;
    }

    public ArrayList<Integer> getTotal_reps() {
        return total_reps;
    }

    public ArrayList<Integer> getTime() {
        return time;
    }

    public ArrayList<Integer> getKms_only_distance() {
        return kms_only_distance;
    }

    public ArrayList<Integer> getKms_altimetry() {
        return kms_altimetry;
    }

    public ArrayList<Integer> getCalories() {
        return calories;
    }

    public ArrayList<Integer> getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(ArrayList<Integer> heart_rate) {
        this.heart_rate = heart_rate;
    }

    public int getCalories_total() {
        return calories_total;
    }

    public void setCalories_total(int calories_total) {
        this.calories_total = calories_total;
    }

    public void setInfoAboutExercise(Exercise exercise, int reps, int time, int km_distance, int km_altimetry, int calories, int heart_rate) {
        this.exercises.add(exercise);
        this.total_reps.add(reps);
        this.time.add(time);
        this.kms_only_distance.add(km_distance);
        this.kms_altimetry.add(km_altimetry);
        this.calories.add(calories);
        this.heart_rate.add(heart_rate);
    }
}
