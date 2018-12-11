package luis_alberto_curiel.ipsmarchamalo;

public class Mesa {

    private String id;
    private String equipo;
    private String envio;
    private String precio;
    private String ticket;
    private String reader;

    public Mesa(String id, String equipo, String envio, String precio, String ticket, String reader) {
        super();
        this.id = id;
        this.equipo = equipo;
        this.envio = envio;
        this.precio = precio;
        this.ticket = ticket;
        this.reader = reader;
    }

    public Mesa() {
        // TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}
