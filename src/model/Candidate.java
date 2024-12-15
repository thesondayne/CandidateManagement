package model;

import java.time.LocalDate;

public class Candidate {
    public static enum CandidateType {
        Experience, Fresher, Intern;

        public static CandidateType getTypeByInt(int value){
            switch (value) {
                case 1:
                    return Experience;
                case 2:
                    return Fresher;
                case 3:
                    return Intern;
                default:
                    throw new IllegalArgumentException("Invalid value");
            }
        }
    }

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private CandidateType candidateType;

    public Candidate() {
    }

    public Candidate(int id, String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String email, CandidateType candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return String.format("%-4s%-20s%-20s%-15s%-30s%-15s%-30s%-20s", id, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
    }
}
