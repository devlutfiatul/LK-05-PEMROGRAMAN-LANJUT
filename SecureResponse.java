public class SecureResponse<T> {
    private T data;
    private boolean masked;

    public SecureResponse(T data, boolean masked) {
        this.data = data;
        this.masked = masked;
    }

    public T getData() {
        return data;
    }

    public boolean isMasked() {
        return masked;
    }
}