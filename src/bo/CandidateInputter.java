package bo;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Validation;

import java.time.LocalDate;

public class CandidateInputter {
    private Candidate c;

    public CandidateInputter(Candidate.CandidateType type) {
        switch (type) {
            case Experience:
                c = new Experience();
                break;
            case Fresher:
                c = new Fresher();
                break;
            case Intern:
                c = new Intern();
                break;
            default:
                throw new AssertionError();
        }
        c.setCandidateType(type);
    }

    private void inputCommonInformation() {
        c.setFirstName(Validation.getStringByRegex("Enter first name:", "[A-Za-z ]+", "Firstname contains only alphabetic characters"));
        c.setLastName(Validation.getStringByRegex("Enter last name:", "[A-Za-z ]+", "Lastname contains only alphabetic characters"));
        c.setBirthDate(Validation.getDateInRange("Enter birth date:", "dd-MM-yyyy", "Date must be in format (dd-MM-yyyy)", LocalDate.of(1900, 1, 1), LocalDate.now()));
        c.setAddress(Validation.getStringByRegex("Enter address:", "[A-Za-z0-9 ]+", "Address contains only alphanumeric characters"));
        c.setPhoneNumber(Validation.getPhoneNumber("Enter phone number:"));
        c.setEmail(Validation.getEmail("Enter email:"));
    }

    private void inputExperience() {
        int max = LocalDate.now().getYear() - c.getBirthDate().getYear();
        int yearOfExperience = Validation.getIntInRange("Enter year of experience", "Input number!", "Year of experience of this candidate must be from 0 to " + max, 0, max);
        ((Experience) c).setYearOfExperience(yearOfExperience);
        ((Experience) c).setProfessionalSkill(Validation.getStringByRegex("Enter professional skill:", ".+", "Skill cannot be empty"));
    }

    private void inputFresher() {
        ((Fresher) c).setGraduationDate(Validation.getDateInRange("Enter graduation date:", "dd-MM-yyyy", "Date must be in format (dd-MM-yyyy)", c.getBirthDate(), LocalDate.now()));
        int rank = Validation.getIntInRange("Enter graduation rank( 1-Excellence; 2-Good; 3-Fair; 4-Poor):", "Input number!", "Input must be from 1 to 4", 1, 4);
        ((Fresher) c).setGraduationRank(Fresher.GraduationRank.getByInt(rank));
        ((Fresher) c).setUniversity(Validation.getStringByRegex("Enter university:", "[A-Za-z ]+", "University contains only alphabetic characters"));
    }

    private void inputIntern() {
        ((Intern) c).setMajors(Validation.getStringByRegex("Enter major:", "[A-Za-z ]+", "Major contains only alphabetic characters"));
        ((Intern) c).setSemester(Validation.getIntInRange("Enter semester:", "Semester must be a number", "Semester must be greater than 0", 0, Integer.MAX_VALUE));
        ((Intern) c).setUniversityName(Validation.getStringByRegex("Enter university name:", "[A-Za-z ]+", "University contains only alphabetic characters"));
    }

    public Candidate inputCandidate() {
        inputCommonInformation();
        switch (c.getCandidateType()) {
            case Experience:
                inputExperience();
                break;
            case Fresher:
                inputFresher();
                break;
            case Intern:
                inputIntern();
                break;
            default:
                throw new AssertionError();
        }
        return c;
    }
}
