package byps.gen.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.gen.api.Generator;
import byps.gen.api.GeneratorProperties;
import byps.gen.db.ClassDB;

public class GeneratorRest implements Generator {
  
  Logger log = LoggerFactory.getLogger(GeneratorRest.class);
  
  private PrintContext pctxt;

  @Override
  public void build(ClassDB classDB, GeneratorProperties props) throws IOException {
    
    pctxt = new PrintContext(classDB, props);
    
  }
}
