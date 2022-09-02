package com.web.todo.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RandomQuote {
    private final String URL = "https://api.quotable.io/random";

    public List<String> getRandomQuote() {
        List<String> quoteData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(new URL(URL));
            quoteData.add(jsonNode.get("content").asText());
            quoteData.add(jsonNode.get("author").asText());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return quoteData;
    }
}
