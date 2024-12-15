package view;

import util.Validation;

public class Menu {
    public int getChoice(){
        System.out.println("----- Candidate Menu -----");
        System.out.println("1. Add Experience");
        System.out.println("2. Add Fresher");
        System.out.println("3. Add Intern");
        System.out.println("4. Delete candidate by id");
        System.out.println("5. Update candidate by id");
        System.out.println("6. Display all candidates");
        System.out.println("7. Search candidates by name");
        System.out.println("8. Sort candidates by birthdate");
        System.out.println("9. Exit");
        return Validation.getIntInRange("Enter your choice:", "Input a number!!!", "Your choice must be from 1 to 9", 1, 9);
    }
}
