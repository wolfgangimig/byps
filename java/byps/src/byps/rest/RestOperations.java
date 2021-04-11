package byps.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RestOperations {
  
  public static final RestOperations EMPTY = new RestOperations();
  
  public static class Operation {
    public final String interfaceName;
    public final String functionName;
    public Operation(String operationId) {
      int p = operationId.indexOf('_');
      interfaceName = operationId.substring(0, p);
      functionName = operationId.substring(p+1);
    }
  }
  
  protected RestOperations() {
    
  }
  
  protected Map<String, Operation> map = new HashMap<>();
  
  public Operation getOperation(String method, String path) {
    Operation op = null;
    String lookupPath = method.toLowerCase();
    StringTokenizer stok = new StringTokenizer(path, "/");
    while (stok.hasMoreTokens()) {
      String tok = stok.nextToken();
      lookupPath += "/" + tok;
      op = map.get(lookupPath);
      if (op != null) break;
    }
    return op;
  }
  
  protected void add(String method, String path, Operation operation) {
    String key = method + path;
    map.put(key, operation);
  }
  
}
