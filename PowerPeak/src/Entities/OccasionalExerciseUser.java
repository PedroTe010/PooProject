package Entities;

public class OccasionalExerciseUser extends User {

    public int level_of_exercise = 1;

    public OccasionalExerciseUser(String userId, String password, String name, String address, String email, String averageHeartRate, String weight) {
        super(userId, password, name, address, email, averageHeartRate, weight);
        level_of_exercise = 2;
    }

    public int getLevel_of_exercise() {
        return level_of_exercise;
    }

    public void setLevel_of_exercise(int level_of_exercise) {
        this.level_of_exercise = level_of_exercise;
    }

    public String getGym_level() {
        return "Occasional exercise";
    }
}
