import java.util.Arrays;

public class week5q5 implements Comparable<week5q5> {

    private String name;
    private double cgpa;
    private int codingScore;

    public week5q5(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(week5q5 other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    static String shortlistAndRank(week5q5[] candidates) {

        int count = 0;

        for (week5q5 candidate : candidates) {
            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {
                count++;
            }
        }

        week5q5[] shortlisted = new week5q5[count];

        int index = 0;

        for (week5q5 candidate : candidates) {
            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {
            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        week5q5[] candidates = {
            new week5q5("Aisha", 8.2, 40),
            new week5q5("Rohit", 6.8, 65),
            new week5q5("Meena", 6.0, 90),
            new week5q5("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}

