package model;

/**
 * Model class for Client
 */

public class Client {
    private int clientId;
    private String clientName;
    private String clientEmail;

    public Client(int clientId, String clientName, String clientEmail) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public Client(String clientName, String clientEmail) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public Client() {

    }


    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }



    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Client " +
                  clientId +":"+
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
