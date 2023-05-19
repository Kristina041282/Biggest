import com.fasterxml.jackson.annotation.JsonInclude;
public class StationsJson {

    private String name;
    private String line;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double depth;
    private boolean hasConnection;

    public StationsJson(String name, String line, String date, Double depth, boolean hasConnection) {
        this.name =name;
        this.line = line;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public StationsJson(){
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDepth(Double depth) {
        this.depth = depth;
    }
    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }
    public String getName() {
        return name;
    }
    public String getLine() {
        return line;
    }
    public String getDate() {
        return date;
    }
    public Double getDepth() {
        return depth;
    }
    public boolean isHasConnection() {
        return hasConnection;
    }


}
