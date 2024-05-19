package Entities;

import java.io.Serializable;

public abstract class Exercise implements Serializable {

    private int id;
    private String name;
    private String material;
    private String description;
    private boolean hard;

    public Exercise(int id, String name, String material, String description, boolean hard) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.description = description;
        this.hard = false;
    }

    public Exercise() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHard() {
        return hard;
    }

    public void setHard(boolean hard) {
        this.hard = hard;
    }

    public abstract int calories_spent(User user, int durationMinutes, int heart_rate);
    
    public String getMuscle(Object obj) {
        if(obj instanceof Hypertrophy) {
            return ((Hypertrophy) obj).getMuscle();
        }
        return "";
    }

    public void setMuscle(Object obj, String muscle) {
        if(obj instanceof Hypertrophy) {
            ((Hypertrophy) obj).setMuscle(muscle);
        }
    }


    public static Exercise allocateExercise(int type){
        switch (type) {
            case 1:
                return new Hypertrophy();
            case 2:
                return new Repetitions();
            case 3:
                return new DistanceAndAltimetry();
            case 4:
                return new Distance();
            case 5:
                return new Cardio();
            default:
                return new Hypertrophy();
        }
    }

    public abstract String getType();
}
