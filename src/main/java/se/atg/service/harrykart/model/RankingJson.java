package se.atg.service.harrykart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ranking"
})
public class RankingJson {

    @JsonProperty("ranking")
    private List<Ranking> ranking = null;

    @JsonProperty("ranking")
    public List<Ranking> getRanking() {
        return ranking;
    }

    @JsonProperty("ranking")
    public void setRanking(List<Ranking> ranking) {
        this.ranking = ranking;
    }

}
