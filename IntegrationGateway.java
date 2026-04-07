public class IntegrationGateway<T extends MedicalRecord & Versioned & Confidential> {

    private T record;

    public IntegrationGateway(T record) {
        this.record = record;
    }

    public SecureResponse<String> fetchData(String patientId, int clearanceLevel) {

        if (!record.getPatientId().equals(patientId)) {
            return new SecureResponse<>("Data tidak ditemukan", true);
        }

        if (clearanceLevel < record.getSecurityLevel()) {
            return new SecureResponse<>(record.getMaskedData(clearanceLevel), true);
        }

        return new SecureResponse<>(record.toString(), false);
    }
}