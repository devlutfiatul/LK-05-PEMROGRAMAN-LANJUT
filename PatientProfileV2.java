public class PatientProfileV2 implements MedicalRecord, Versioned, Confidential {

    private String patientId;
    private String name;
    private String ssn;
    private String allergyHistory;
    private String medicalHistory;
    private int version;

    public PatientProfileV2(String patientId, String name, String ssn,
                            String allergyHistory, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.allergyHistory = allergyHistory;
        this.medicalHistory = medicalHistory;
        this.version = 2;
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
        return 3; 
    }

    @Override
    public String getMaskedData(int clearanceLevel) {

        if (clearanceLevel == 1) {
            return "PatientID: " + patientId +
                   ", Name: " + name +
                   ", SSN: ******" +
                   ", Allergy: ******" +
                   ", Medical History: ******";
        }

        if (clearanceLevel == 2) {
            return "PatientID: " + patientId +
                   ", Name: " + name +
                   ", SSN: ******" +
                   ", Allergy: " + allergyHistory +
                   ", Medical History: " + medicalHistory;
        }

        return toString();
    }

    @Override
    public String toString() {
        return "PatientID: " + patientId +
               ", Name: " + name +
               ", SSN: " + ssn +
               ", Allergy: " + allergyHistory +
               ", Medical History: " + medicalHistory;
    }
}