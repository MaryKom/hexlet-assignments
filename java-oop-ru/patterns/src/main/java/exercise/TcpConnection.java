package exercise;
import java.util.List;
import java.util.ArrayList;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private String address;
    private int port;
    private Connection state;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection (String address, int port) {
        this.address = address;
        this.port = port;
        this.state = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.state.getStateName();
    }

    public void connect() {
        this.state.connect();
    }

    public void disconnect() {
        this.state.disconnect();
    }

    public void write(String data) {
        //System.out.println(this.state.getStateName());
        this.getState().write(data);
        //String d = getState().write(data);
        //if (d != null) {
        //    buffer.add(d);
        //}
        //System.out.println(buffer);
        //buffer.add(d);
        //return d;
    }

    private Connection getState() {
        return state;
    }

    public void setState(Connection connection) {
        this.state = connection;
    }
}
// END
