package byps.test.api.prim;

/**
 * An interface that does not extend BRemote.
 * This is used to check generator options OPT_ALL_REMOTES and OPT_ONLY_BREMOTES.
 * BYPS-22
 */
public interface InterfaceToIgnore {

  public void ignoreThisInterface();
}
