package com.prasanth.testdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFromFile(String filePath) throws IOException {
        return objectMapper.readTree(new File(filePath));
    }

    public static String getValueFromJson(JsonNode jsonNode, String jsonPath) {
        JsonNode node = jsonNode.at(jsonPath);
        return node.isMissingNode() ? null : node.asText();
    }

    public static void updateValueInJson(JsonNode jsonNode, String jsonPath, String newValue, String filePath) throws IOException {
        ((com.fasterxml.jackson.databind.node.ObjectNode) jsonNode).put(jsonPath, newValue);
        objectMapper.writeValue(new File(filePath), jsonNode);
    }

}
