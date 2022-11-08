package com.rutas.signup.infraestructure.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataBody {
    @JsonProperty("Errors")
    private void StringTokenizer(String errors) {

    }

    @JsonProperty("Data")
    private String data;
    @JsonProperty("Message")
    private String message;
}
