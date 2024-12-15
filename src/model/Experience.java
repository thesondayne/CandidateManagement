package model;

public class Experience extends Candidate {
    private int yearOfExperience;
    private String professionalSkill;

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-5s%-15s", yearOfExperience, professionalSkill);
    }
}
