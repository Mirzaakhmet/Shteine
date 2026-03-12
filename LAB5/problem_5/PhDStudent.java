package week_5.problem_5;

public class PhDStudent extends Person {
    private final String researchTopic;

    public PhDStudent(String name, int age, String researchTopic) {
        super(name, age);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() { return researchTopic; }

    @Override
    public boolean assignPet(Animal pet) {
        if (pet instanceof Dog) return false;
        return super.assignPet(pet);
    }

    @Override
    public String getOccupation() {
        return "PhDStudent(" + researchTopic + ")";
    }
}