package byps.http;

/**
 * Control message completion.
 * The values of this enum specify whether a message should be removed or 
 * put into waiting state. 
 * BYPS-9: Avoid socket exception while uploading large files.
 */
public enum HRemoveMessageControl {
  
  /**
   * Message is finished and will be removed.
   */
  FINISHED,
  
  /**
   * Message is still processed and waits for a new request context.
   */
  PROCESSING
}
