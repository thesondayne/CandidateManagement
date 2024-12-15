package bo;

import model.Candidate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateManager {
    private final List<Candidate> candidates;
    private int lastId;

    public CandidateManager() {
        candidates = new ArrayList<>();
        lastId = 0;
    }

    private int searchById(int id) {
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Candidate getCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.get(index);
        }
        throw new Exception("Id not found");
    }

    public List<Candidate> getAllCandidates() {
        return candidates;
    }

    public boolean addCandidate(Candidate c) {
        if (c != null) {
            c.setId(++lastId);
            return candidates.add(c);
        }
        return false;
    }

    public Candidate deleteCandidateById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return candidates.remove(index);
        }
        throw new Exception("Candidate not found");
    }

    public Candidate updateCandidate(int id, Candidate c) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            c.setId(id);
            candidates.set(index, c);
            return c;
        }
        throw new Exception("Candidate not found");
    }


    public List<Candidate> searchCandidateByName(String name) {
        return candidates.stream().filter(c -> (c.getFirstName().toLowerCase().contains(name.toLowerCase())
                || c.getLastName().toLowerCase().contains(name.toLowerCase()))).collect(Collectors.toList());
    }

    public List<Candidate> sortCandidateByBirthdate() {
        return candidates.stream()
                .sorted(Comparator.comparing(Candidate::getBirthDate))
                .toList();
    }
}
