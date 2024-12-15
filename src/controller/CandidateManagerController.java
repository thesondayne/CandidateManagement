package controller;

import bo.CandidateInputter;
import bo.CandidateManager;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Validation;

import java.util.ArrayList;
import java.util.List;

public class CandidateManagerController {
    private final CandidateManager candidateManager;
    private CandidateInputter candidateInputter;

    public CandidateManagerController() {
        candidateManager = new CandidateManager();
    }

    private Candidate inputCandidate(Candidate.CandidateType type) {
        candidateInputter = new CandidateInputter(type);
        Candidate c = candidateInputter.inputCandidate();
        if (candidateManager.addCandidate(c)) {
            return c;
        }
        return null;
    }

    public Experience addExperience() {
        return (Experience) inputCandidate(Candidate.CandidateType.Experience);
    }

    public Fresher addFresherCandidate() {
        return (Fresher) inputCandidate(Candidate.CandidateType.Fresher);
    }

    public Intern addInternCandidate() {
        return (Intern) inputCandidate(Candidate.CandidateType.Intern);
    }

    public List<Candidate> addCandidatesByOptions(int choice) {
        List<Candidate> tmp = new ArrayList<>();
        do {
            Candidate c = null;
            switch (choice) {
                case 1:
                    c = addExperience();
                    break;
                case 2:
                    c = addFresherCandidate();
                    break;
                case 3:
                    c = addInternCandidate();
                    break;
            }
            if (c != null) {
                tmp.add(c);
            }
        } while (Validation.getYNOption("Do you want to continue? (Y/N)"));
        return tmp;
    }

    public Candidate deleteCandidateById() throws Exception {
        int id = Validation.getIntInRange("Enter id:", "Id must be a number", "Id must be from 1 to " + Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        return candidateManager.deleteCandidateById(id);
    }

    public Candidate updateCandidateById() throws Exception {
        int id = Validation.getIntInRange("Enter id:", "Id must be a number", "Id must be from 1 to " + Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
        Candidate c = candidateManager.getCandidateById(id);
        candidateInputter = new CandidateInputter(c.getCandidateType());
        c = candidateInputter.inputCandidate();
        return candidateManager.updateCandidate(id, c);
    }

    public List<Candidate> getAllCandidates() {
        return candidateManager.getAllCandidates();
    }

    public List<Candidate> searchCandidateByName() {
        String name = Validation.getStringByRegex("Enter name to find:", "[A-Za-z ]+", "Name contains only alphabetic characters");
        return candidateManager.searchCandidateByName(name);
    }

    public List<Candidate> getSortedCandidatesByBirthdate() {
        return candidateManager.sortCandidateByBirthdate();
    }
}
