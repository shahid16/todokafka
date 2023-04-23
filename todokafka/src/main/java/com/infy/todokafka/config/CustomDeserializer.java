/*
 * import java.io.IOException;
 * 
 * import com.fasterxml.jackson.core.JsonParser; import
 * com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.databind.DeserializationContext; import
 * com.fasterxml.jackson.databind.JsonNode; import
 * com.fasterxml.jackson.databind.deser.std.StdDeserializer; import
 * com.infy.todokafka.entity.Priority;
 * 
 * public class CustomDeserializer extends StdDeserializer<Priority> {
 * 
 * @Override public Priority deserialize(JsonParser jsonParser,
 * DeserializationContext ctxt) throws IOException, JsonProcessingException {
 * JsonNode node = jsonParser.getCodec().readTree(jsonParser);
 * 
 * String unit = node.get("unit").asText(); double meters =
 * node.get("meters").asDouble();
 * 
 * for (Priority priority : Priority.values()) {
 * 
 * if (priority.equals(unit) && Double.compare( distance.getMeters(), meters) ==
 * 0) { return distance; } }
 * 
 * return null; } }
 */