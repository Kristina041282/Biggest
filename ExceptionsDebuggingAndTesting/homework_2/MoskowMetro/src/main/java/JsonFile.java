import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

//этот класс нужен для связки с классом ParsingFiles (в pojo)
    public class JsonFile {
    @JsonProperty("station_name")
        private String name;
        private String depth;

        public JsonFile() {
        }

        public JsonFile(String name, String depth) {
            this.name = name;
            this.depth = depth;
        }

        public void setStationName(String name) {
            this.name = name;
        }

        public void setDepth(String depth) {
            this.depth = depth;
        }

        public String getStationName() {
            return name;
        }
        public String getDepth() {
            return depth;
        }
        public String toString() {
            return name + " " + depth;
        }
    }
