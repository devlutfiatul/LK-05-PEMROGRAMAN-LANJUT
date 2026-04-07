public class PatientProfileV1 implements MedicalRecord, Versioned, Confidential {

    private String patientId;
    private String name;
    private String ssn;
    private int version;

    public PatientProfileV1(String patientId, String name, String ssn) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.version = 1;
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public int getSecurityLevel() {
        return 2;
    }

    @Override
    public String getMaskedData(int clearanceLevel) {

        if (clearanceLevel == 1) {
            return "PatientID: " + patientId +
                   ", Name: " + name +
                   ", SSN: ******";
        }

        return toString();
    }

    @Override
    public String toString() {
        return "PatientID: " + patientId +
               ", Name: " + name +
               ", SSN: " + ssn;
    }
}