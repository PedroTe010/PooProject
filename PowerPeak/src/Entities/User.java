package Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class User implements Serializable{

    private String userId;
    private String name;
    private String password;
    private String address;
    private String email;
    private String averageHeartRate;
    private String weight;
    private LocalDate date;
    private Plan trainingPlan;
    private UserStats userStats;
    private ArrayList<Historic> historics;

    public User() {
    }

    public User(String userId, String password, String name, String address, String email, String averageHeartRate, String weight) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.averageHeartRate = averageHeartRate;
        this.weight = weight;
        this.date = null;
        this.trainingPlan = new Plan();
        this.userStats = new UserStats();
        this.historics = new ArrayList<>();
    }

    public static User allocateUser(String userId, String password, String name, String address, String email, String averageHeartRate, String weight, String gym_level) {
        switch (gym_level) {
            case "Professional":
                return new ProfessionalUser(userId, password, name, address, email, averageHeartRate, weight);
            case "Amateur":
                return new AmateurUser(userId, password, name, address, email, averageHeartRate, weight);
            case "Occasional Exercise":
                return new OccasionalExerciseUser(userId, password, name, address, email, averageHeartRate, weight);
            default:
                // Handle invalid gym_level
                throw new IllegalArgumentException("Invalid gym level: " + gym_level);
        }
    }
    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String user_code) {
        this.userId = user_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(String averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public String getWeight() { return weight;}

    public void setWeight(String weight) { this.weight = weight;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Plan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(Plan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public ArrayList<Historic> getHistorics() {
        return historics;
    }

    public void setHistorics(ArrayList<Historic> historics) {
        this.historics = historics;
    }

    public void setHistoricsLine(Historic historic) {
        this.historics.add(historic);
    }

    public abstract int getLevel_of_exercise();

    public abstract String getGym_level();
}