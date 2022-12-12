package exercise.connections;

public interface Connection {
    // BEGIN
    String getStateName();
    void connect();
    void disconnect();
    void write(String data);
    // END
}
