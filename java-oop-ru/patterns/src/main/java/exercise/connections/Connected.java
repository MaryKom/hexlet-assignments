package exercise.connections;
import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection connection;
    private final String STATE_NAME = "connected";

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getStateName() {
        return this.STATE_NAME;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already connected");
    }

    @Override
    public void disconnect() {
        connection.setState(new Disconnected(connection));
    }

    @Override
    public void write (String data) {
        System.out.println(data);
    }
}
// END
