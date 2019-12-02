package byps;

import java.util.ArrayList;

public class BRegistryCollection extends BRegistry {

  private ArrayList<BRegistry> registries = new ArrayList<BRegistry>();

  public BRegistryCollection(BBinaryModel bmodel) {
    super(bmodel);
  }
  
  public void add(BRegistry registry) {
    if (registry.bmodel != bmodel) throw new IllegalStateException("Different binary model.");
    registries.add(registry);
  }

  @Override
  protected BRegisteredSerializer[] getSortedSerializers() {
    throw new UnsupportedOperationException();
  }

  @Override
  protected BSerializer internalGetSerializer(int typeId) throws BException {
    BSerializer ser = null;
    for (BRegistry reg : registries) {
      ser = reg.internalGetSerializer(typeId);
      if (ser != null) break;
    }
    return ser;
  }

  public boolean isEmpty() {
    return registries.isEmpty();
  }

  @Override
  public boolean replaceSerializer(BSerializer bser) {
    for (BRegistry reg : registries) {
      if (reg.replaceSerializer(bser)) {
        return true;
      }
    }
    return false;
  }
}
