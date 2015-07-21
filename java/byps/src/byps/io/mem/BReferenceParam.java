package byps.io.mem;

public class BReferenceParam<T> {
  public Class<T> clazz; 
  public T value;
  
  public BReferenceParam(Class<T> clazz) {
    this.clazz = clazz;
  }
  
  @SuppressWarnings("unchecked")
  public BReferenceParam(T value) {
    this.clazz = (Class<T>)value.getClass();
    this.value = value;
  }
}
