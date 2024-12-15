package view;

import model.Candidate;

import java.util.List;
import java.util.stream.Collectors;

public class Display {
    private final String candidateHeader = String.format("%-4s%-20s%-20s%-15s%-30s%-15s%-30s%-20s", "ID",
            "Firstname", "Lastname", "Birthdate", "Address", "Phone Number", "Email", "Candidate Type");
    private final String experienceHeader = String.format("%-4s%-20s%-20s%-15s%-30s%-15s%-30s%-20s%-5s%-15s", "ID",
            "Firstname", "Lastname", "Birthdate", "Address", "Phone Number", "Email", "Candidate Type", "Year", "Skill");
    private final String fresherHeader = String.format("%-4s%-20s%-20s%-15s%-30s%-15s%-30s%-20s%-20s%-20s%-20s", "ID",
            "Firstname", "Lastname", "Birthdate", "Address", "Phone Number", "Email", "Candidate Type", "GraduationDate", "GraduationRank", "University");
    private final String internHeader = String.format("%-4s%-20s%-20s%-15s%-30s%-15s%-30s%-20s%-15s%-10s%-20s", "ID",
            "Firstname", "Lastname", "Birthdate", "Address", "Phone Number", "Email", "Candidate Type", "Majors", "Semester", "UniversityName");

    public String getDisplayStringByType(List<Candidate> candidateList, Candidate.CandidateType type) {
        StringBuilder result = new StringBuilder();
        switch (type) {
            case Experience:
                result = new StringBuilder(experienceHeader);
                break;
            case Fresher:
                result = new StringBuilder(fresherHeader);
                break;
            case Intern:
                result = new StringBuilder(internHeader);
                break;
        }
        int count = 0;
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type) {
                count++;
                result.append("\n");
                result.append(c);
            }
        }
        if (count == 0) {
            return "No have any " + type;
        }
        return result.toString();
    }

    public String getDisplayCandidatesFromList(List<Candidate> candidateList) {
        return "----- Experience -----" + "\n" + getDisplayStringByType(candidateList, Candidate.CandidateType.Experience) +
                "\n" + "----- Fresher -----" + "\n" + getDisplayStringByType(candidateList, Candidate.CandidateType.Fresher) +
                "\n" + "----- Intern -----" + "\n" + getDisplayStringByType(candidateList, Candidate.CandidateType.Intern);
    }

    public String getDisplayCommonInfo(List<Candidate> candidateList) {
        if(candidateList.isEmpty()) {
            return "No have any candidate";
        }
        return candidateHeader + candidateList.stream().map(c -> ((Candidate) c).toString()).collect(Collectors.joining("\n"));
    }
    public String getDisplayCandidateString(Candidate candidate) {
        StringBuilder result = new StringBuilder();
        switch (candidate.getCandidateType()) {
            case Experience:
                result = new StringBuilder(experienceHeader);
                break;
            case Fresher:
                result = new StringBuilder(fresherHeader);
                break;
            case Intern:
                result = new StringBuilder(internHeader);
                break;
        }
        result.append("\n").append(candidate);
        return result.toString();
    }
}
