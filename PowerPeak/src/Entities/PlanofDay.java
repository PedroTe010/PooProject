package Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class PlanofDay implements Serializable {
    private ArrayList<Exercise> exercises;

    public PlanofDay() {
        this.exercises = new ArrayList<Exercise>();
    }

    public void setExerciseofPlanofDay(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public Exercise getExerciseofPlanofDay(int index) {
        return exercises.get(index);
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}

