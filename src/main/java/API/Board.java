package API;

public class Board {
    private String name;
    private String id;
    private String key = "291f32553575420dacbd791569771799";
    private String token = "6488c5ed5003cc1c5dd3ce49a8296250131170cda5ce0832b88d4d574c4cb829";

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
