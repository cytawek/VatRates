package pl.cytawek.vatRates.dtos;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "effective_from",
        "rates"
})
public class PeriodDto {

    @JsonProperty("effective_from")
    private String effectiveFrom;
    @JsonProperty("rates")
    private RatesDto rates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("effective_from")
    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    @JsonProperty("effective_from")
    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    @JsonProperty("rates")
    public RatesDto getRatesDto() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRatesDto(RatesDto rates) {
        this.rates = rates;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}