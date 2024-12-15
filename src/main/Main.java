package main;

import controller.CandidateManagerController;
import model.Candidate;
import view.Display;
import view.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Display display = new Display();
        CandidateManagerController controller = new CandidateManagerController();
        while (true) {
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    List<Candidate> experience = controller.addCandidatesByOptions(1);
                    if (experience.isEmpty()) {
                        System.out.println("No candidate added");
                        break;
                    }
                    System.out.println("List of candidate has been added");
                    System.out.println(display.getDisplayStringByType(experience, Candidate.CandidateType.Experience));
                    break;
                case 2:
                    List<Candidate> fresher = controller.addCandidatesByOptions(2);
                    if (fresher.isEmpty()) {
                        System.out.println("No candidate added");
                        break;
                    }
                    System.out.println("List of candidate has been added");
                    System.out.println(display.getDisplayStringByType(fresher, Candidate.CandidateType.Fresher));
                    break;
                case 3:
                    List<Candidate> intern = controller.addCandidatesByOptions(3);
                    if (intern.isEmpty()) {
                        System.out.println("No candidate added");
                        break;
                    }
                    System.out.println("List of candidate has been added");
                    System.out.println(display.getDisplayStringByType(intern, Candidate.CandidateType.Intern));
                    break;
                case 4:
                    try {
                        Candidate deleteCandidate = controller.deleteCandidateById();
                        System.out.println("Candidate with id " + deleteCandidate.getId() + " has been deleted");
                        System.out.println(display.getDisplayCandidateString(deleteCandidate));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        Candidate updateCandidate = controller.updateCandidateById();
                        System.out.println("Candidate with id " + updateCandidate.getId() + " has been updated");
                        System.out.println(display.getDisplayCandidateString(updateCandidate));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(display.getDisplayCandidatesFromList(controller.getAllCandidates()));
                    break;
                case 7:
                    System.out.println(display.getDisplayCandidatesFromList(controller.searchCandidateByName()));
                    break;
                case 8:
                    System.out.println("List of candidate has been sorted by birthdate");
                    System.out.println(display.getDisplayCommonInfo(controller.getSortedCandidatesByBirthdate()));
                    break;
                case 9:
                    System.out.println("Exiting program");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
