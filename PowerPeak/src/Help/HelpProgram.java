package Help;

import Entities.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class HelpProgram {

    Random rand = new Random();

    public void clean() {
        //LIMPAR A CONSOLA
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean validateEmail(String email) {
        String EMAIL_REGEX =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumberInArray(int[] array, int number) {
        return isInArray(array, number);
    }

    public boolean isAdmin(User user) {
        return user.getUserId().equals("GomesAdmin") || user.getUserId().equals("PedroAdmin") || user.getUserId().equals("JoãoNunoAdmin");
    }

    public boolean hasHard(ArrayList<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            if (exercise.isHard()) return true;
        }
        return false;
    }

    public int dayWeek(LocalDate date) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            switch (dayOfWeek) {
                case MONDAY:
                    return 1;
                case TUESDAY:
                    return 2;
                case WEDNESDAY:
                    return 3;
                case THURSDAY:
                    return 4;
                case FRIDAY:
                    return 5;
                case SATURDAY:
                    return 6;
                case SUNDAY:
                    return 7;
                default:
                    throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
            }
        }

    public static boolean isInArray(int[] array, int target) {
    for (int element : array) {
        if (element == target) {
            return true;
        }
    }
    return false;
    }

    public boolean hasWeights_or_Reps(ArrayList<Exercise> exercises){
        for (Exercise exercise : exercises) {
            if (exercise instanceof Hypertrophy || exercise instanceof Repetitions) return true;
        }
        return false;
    }
    public boolean hasDistance_Altimetry(ArrayList<Exercise> exercises){
        for (Exercise exercise : exercises) {
            if (exercise instanceof DistanceAndAltimetry) return true;
        }
        return false;
    }
    public boolean hasDistance(ArrayList<Exercise> exercises){
        for (Exercise exercise : exercises) {
            if (exercise instanceof Distance) return true;
        }
        return false;
    }
    public boolean hasCardio(ArrayList<Exercise> exercises){
        for (Exercise exercise : exercises) {
            if (exercise instanceof Cardio) return true;
        }
        if (hasDistance(exercises)) return true;
        return hasDistance_Altimetry(exercises);
    }

}
