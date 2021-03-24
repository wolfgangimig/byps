package byps.gen.rest;

import java.util.Map;
import java.util.stream.Collectors;

import io.swagger.v3.oas.models.media.Schema;

class SchemaN {

  private String name;
  
  private Schema schema;

  SchemaN(String name, Schema schema) {
    super();
    this.name = name;
    this.schema = schema;
  }

  String getName() {
    return name;
  }

  Schema getSchema() {
    return schema;
  }
  
  static Map<String, Schema> toComponentSchemas(Map<String, SchemaN> map) {
    return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getSchema()));
  }
}
