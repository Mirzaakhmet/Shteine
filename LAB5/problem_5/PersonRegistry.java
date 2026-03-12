package week_5.problem_5;

import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {

    private static class VacationRecord {
        Person owner;
        Person caretaker;
        Animal pet;

        VacationRecord(Person owner, Person caretaker, Animal pet) {
            this.owner = owner;
            this.caretaker = caretaker;
            this.pet = pet;
        }
    }

    private final List<Person> people = new ArrayList<>();
    private final List<VacationRecord> vacations = new ArrayList<>();

    public void addPerson(Person p) {
        if (p == null) return;
        if (!people.contains(p)) people.add(p);
    }

    public boolean removePerson(Person p) {
        if (p == null) return false;

        if (findVacationByOwner(p) != null || findVacationByCaretaker(p) != null) {
            return false;
        }

        return people.remove(p);
    }

    public List<Person> findPeopleWithPets() {
        List<Person> res = new ArrayList<>();
        for (Person p : people) if (p.hasPet()) res.add(p);
        return res;
    }

    public List<Person> findPeopleWithoutPets() {
        List<Person> res = new ArrayList<>();
        for (Person p : people) if (!p.hasPet()) res.add(p);
        return res;
    }

    public boolean leavePetWith(Person owner, Person caretaker) {
        if (owner == null || caretaker == null) return false;
        if (!people.contains(owner) || !people.contains(caretaker)) return false;

        if (!owner.hasPet()) return false;
        if (caretaker.hasPet()) return false;

        if (findVacationByOwner(owner) != null) return false;

        Animal pet = owner.getPet();

        if (owner instanceof PhDStudent && pet instanceof Dog) return false;
        if (caretaker instanceof PhDStudent && pet instanceof Dog) return false;

        owner.removePet();
        if (!caretaker.assignPet(pet)) {
            owner.assignPet(pet);
            return false;
        }

        vacations.add(new VacationRecord(owner, caretaker, pet));
        return true;
    }

    public boolean retrievePetFrom(Person owner) {
        VacationRecord rec = findVacationByOwner(owner);
        if (rec == null) return false;

        if (owner.hasPet()) return false;

        rec.caretaker.removePet();
        if (!owner.assignPet(rec.pet)) {
            rec.caretaker.assignPet(rec.pet);
            return false;
        }

        vacations.remove(rec);
        return true;
    }

    private VacationRecord findVacationByOwner(Person owner) {
        for (VacationRecord r : vacations) {
            if (r.owner.equals(owner)) return r;
        }
        return null;
    }

    private VacationRecord findVacationByCaretaker(Person caretaker) {
        for (VacationRecord r : vacations) {
            if (r.caretaker.equals(caretaker)) return r;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Registry ===\n");
        for (Person p : people) sb.append(p).append("\n");

        sb.append("=== Vacations ===\n");
        if (vacations.isEmpty()) sb.append("none\n");
        for (VacationRecord v : vacations) {
            sb.append(v.owner.getName())
              .append(" left ")
              .append(v.pet)
              .append(" with ")
              .append(v.caretaker.getName())
              .append("\n");
        }
        return sb.toString();
    }
}