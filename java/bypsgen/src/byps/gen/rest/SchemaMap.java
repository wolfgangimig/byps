package byps.gen.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import byps.gen.api.TypeInfo;
import io.swagger.v3.oas.models.media.Schema;

class SchemaMap {

  private Map<TypeInfo, Schema> map = new HashMap<>();
  
  void put(TypeInfo tinfo, Schema schema) {
    map.put(tinfo, schema);
  }
  
  Schema get(TypeInfo tinfo) {
    return map.get(tinfo);
  }
  
  Map<String, Schema> toComponents() {
    return map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().name, Map.Entry::getValue));
  }

}
