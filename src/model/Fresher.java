package model;

import java.time.LocalDate;

public class Fresher extends Candidate {
    public static enum GraduationRank {
        Excellence, Good, Fair, Poor;

        public static GraduationRank getByInt(int value) {
            switch (value) {
                case 1:
                    return Excellence;
                case 2:
                    return Good;
                case 3:
                    return Fair;
                case 4:
                    return Poor;
                default:
                    throw new IllegalArgumentException("Invalid value");
            }
        }
    }

    private LocalDate graduationDate;
    private GraduationRank graduationRank;
    private String university;

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-20s%-20s%-20s", graduationDate, graduationRank, university);
    }
}
