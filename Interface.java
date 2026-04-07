public interface MedicalRecord {
    String getPatientId();
}

public interface Versioned {
    int getVersion();
}

public interface Confidential {
    int getSecurityLevel();

    String getMaskedData(int clearanceLevel);
}