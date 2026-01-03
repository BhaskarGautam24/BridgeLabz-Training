import java.util.*;
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // creating resume storage for software engineer
        Resume<SoftwareEngineer> seResumes = new Resume<SoftwareEngineer>();
        Resume<DataScientist> dsResumes = new Resume<DataScientist>();
        System.out.print("enter software engineer name: ");
        String seName = scn.nextLine();
        SoftwareEngineer se = new SoftwareEngineer(seName);
        // adding resume
        seResumes.addResume(se);
        System.out.print("enter data scientist name: ");
        String dsName = scn.nextLine();
        DataScientist ds = new DataScientist(dsName);

        dsResumes.addResume(ds);
        System.out.println("\nscreened resumes:");
        screenResumes(seResumes.getResumes());
        screenResumes(dsResumes.getResumes());
    }

    public static void screenResumes(List<? extends JobRole> list) {

        for (JobRole job : list) {
            System.out.println(job.getProfile());
        }
    }
}

// abstract job role class
abstract class JobRole {

    // candidate name
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    // abstract method
    public abstract String getRoleType();

    public String getProfile() {
        return candidateName + " | role: " + getRoleType();
    }
}

// software engineer role
class SoftwareEngineer extends JobRole {

    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    // overriding method
    public String getRoleType() {
        return "software engineer";
    }
}

// data scientist role
class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    // overriding method
    public String getRoleType() {
        return "data scientist";
    }
}

// product manager role
class ProductManager extends JobRole {

    public ProductManager(String candidateName) {
        super(candidateName);
    }

    // overriding method
    public String getRoleType() {
        return "product manager";
    }
}

// generic resume class
class Resume<T extends JobRole> {

    private List<T> resumes;
    public Resume() {
        resumes = new ArrayList<T>();
    }

    // add resume method
    public void addResume(T role) {
        resumes.add(role);
    }
    public List<T> getResumes() {
        return resumes;
    }
}

