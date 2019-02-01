package byps;

/**
 * This interface is used to support lazy loading of elements.
 * @see BValueClass#bypsClient
 * @see BClient#lazyLoad
 */
public interface BLazyLoad {
  
  /**
   * This function is to be implemented to load a member of the given object.
   * @param bclient BClient
   * @param obj A member of this object should be read 
   * @param members This value can be used to specify which element has to be loaded
   */
  public void lazyLoadMembers(BClient bclient, Object obj, long members);
}
