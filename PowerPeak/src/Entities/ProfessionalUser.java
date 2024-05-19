package Entities;

public class ProfessionalUser extends User {

    public int level_of_exercise;

    public ProfessionalUser(String userId, String password, String name, String address, String email, String averageHeartRate, String weight) {
        super(userId, password, name, address, email, averageHeartRate, weight);
        this.level_of_exercise = 2;
    }

    @Override
    public int getLevel_of_exercise() {
        return level_of_exercise;
    }

    public void setLevel_of_exercise(int level_of_exercise) {
        this.level_of_exercise = level_of_exercise;
    }
    public String getGym_level() {
        return "Professional";
    }
}
