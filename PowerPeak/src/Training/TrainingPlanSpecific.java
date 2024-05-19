package Training;

import Entities.Exercise;
import Entities.PlanofDay;
import Help.HelpProgram;
import Help.Serialization;
import Help.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TrainingPlanSpecific{

    HelpProgram help = new HelpProgram();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    @SuppressWarnings("unchecked")
    public PlanofDay chestDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(9) + 1;
            ex2 = rand.nextInt(9) + 1;
            ex3 = rand.nextInt(9) + 1;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay pushDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(9) + 1;
            ex2 = rand.nextInt(9) + 1;
            ex3 = rand.nextInt(4) + 20;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay pullDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(7) + 32;
            ex2 = rand.nextInt(7) + 32;
            ex3 = rand.nextInt(5) + 15;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay legDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(8) + 24;
            ex2 = rand.nextInt(8) + 24;
            ex3 = rand.nextInt(8) + 24;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay backDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(7) + 32;
            ex2 = rand.nextInt(7) + 32;
            ex3 = rand.nextInt(7) + 32;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay armDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(5) + 15;
            ex2 = rand.nextInt(4) + 20;
            ex3 = rand.nextInt(5) + 10;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay distanceDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(4) + 48;
            ex2 = rand.nextInt(4) + 48;
            ex3 = rand.nextInt(4) + 48;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay distance_altimetryDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(4) + 44;
            ex2 = rand.nextInt(4) + 44;
            ex3 = rand.nextInt(4) + 44;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay cardioDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(3) + 52;
            ex2 = rand.nextInt(3) + 52;
            ex3 = rand.nextInt(5) + 39;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

    @SuppressWarnings("unchecked")
    public PlanofDay absDay() throws IOException, ClassNotFoundException {

        Serialization serialize = new Serialization();
        serialize.setFile("exercises.ser");
        Map<Integer, Exercise> exercisesMap = (Map<Integer, Exercise>) serialize.getObject();
        PlanofDay planofDay = new PlanofDay();

        int ex1 = 0;
        int ex2 = 0;
        int ex3 = 0;
        while (ex1 == ex2 || ex1 == ex3 || ex2 == ex3) {
            ex1 = rand.nextInt(5) + 39;
            ex2 = rand.nextInt(5) + 39;
            ex3 = rand.nextInt(5) + 39;
        }
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex1));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex2));
        planofDay.setExerciseofPlanofDay(exercisesMap.get(ex3));

        return planofDay;
    }

}
