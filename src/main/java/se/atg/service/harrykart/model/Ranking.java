package se.atg.service.harrykart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "position",
        "horse"
})
public class Ranking {

    @JsonProperty("position")
    private int position;
    @JsonProperty("horse")
    private String horse;

    @JsonProperty("position")
    public int getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(int position) {
        this.position = position;
    }

    @JsonProperty("horse")
    public String getHorse() {
        return horse;
    }

    @JsonProperty("horse")
    public void setHorse(String horse) {
        this.horse = horse;
    }

}
