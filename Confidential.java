public interface Confidential {
    int getSecurityLevel();

    String getMaskedData(int clearanceLevel);
}