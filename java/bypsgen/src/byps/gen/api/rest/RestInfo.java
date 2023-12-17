package byps.gen.api.rest;

import java.util.Collection;
import java.util.Optional;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import byps.gen.api.CommentInfo;

/**
 * Declarations for REST methods.
 * BYPS-50
 */
public class RestInfo {

  public static final RestInfo NULL = null;

  private RestMethod method;

  private String path;

  private RestContentType consumes;

  private RestContentType produces;

  public RestInfo() {
  }

  public RestInfo(RestInfo rhs) {
    this.method = rhs.method;
    this.path = rhs.path;
    this.consumes = rhs.consumes;
    this.produces = rhs.produces;
  }

  public boolean isEmpty() {
    return path == null && method == null && consumes == null && produces == null;
  }

  public RestMethod getMethod() {
    return method;
  }

  public void setMethod(RestMethod method) {
    this.method = method;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RestContentType getConsumes() {
    return consumes;
  }

  public void setConsumes(RestContentType consumes) {
    this.consumes = consumes;
  }

  public RestContentType getProduces() {
    return produces;
  }

  public void setProduces(RestContentType produces) {
    this.produces = produces;
  }

  public RestInfo get(GET v) {
    if (v != null) method = RestMethod.GET;
    return this;
  }

  public RestInfo post(POST v) {
    if (v != null) method = RestMethod.POST;
    return this;
  }

  public RestInfo delet(DELETE v) {
    if (v != null) method = RestMethod.DELETE;
    return this;
  }

  public RestInfo consumes(Consumes v) {
    if (v != null) {
      consumes = toContentType(v.value());
    }
    return this;
  }

  public RestInfo produces(Produces v) {
    if (v != null) {
      produces = toContentType(v.value());
    }
    return this;
  }

  public RestInfo path(Path v) {
    if (v != null) path = v.value();
    return this;
  }

  private RestContentType toContentType(String[] mediaTypes) {
    for (String m : mediaTypes) {
      if (m.contentEquals(MediaType.APPLICATION_JSON)) {
        return RestContentType.APPLICATION_JSON;
      }
      if (m.contentEquals(MediaType.MULTIPART_FORM_DATA)) {
        return RestContentType.MULTIPART_FORM_DATA;
      }
    }
    return null;
  }
  
  private RestContentType toContentType(String mediaType) {
    return toContentType(new String[] { mediaType });
  }
  
  private static String toMediaType(RestContentType contentType) {
    if (contentType != null && contentType == RestContentType.MULTIPART_FORM_DATA) {
      return MediaType.MULTIPART_FORM_DATA;
    }
    else {
      return MediaType.APPLICATION_JSON;
    }
  }
  
  public RestInfo applyComments(Collection<CommentInfo> comments) {
    if (hasComment("@GET", comments)) method = RestMethod.GET;
    if (hasComment("@POST", comments)) method = RestMethod.POST;
    if (hasComment("@DELETE", comments)) method = RestMethod.DELETE;
    getComment("@Path", comments).ifPresent(t -> path = t);
    getComment("@Consumes", comments).ifPresent(t -> consumes = toContentType(t));
    getComment("@Produces", comments).ifPresent(t -> produces = toContentType(t));
    return this;
  }

  public static String getConsumesOrDefault(RestInfo restInfo) {
    return toMediaType(restInfo != null ? restInfo.consumes : null);
  }

  public static String getProducesOrDefault(RestInfo restInfo) {
    return toMediaType(restInfo != null ? restInfo.produces : null);
  }

  private Optional<String> getComment(String kind, Collection<CommentInfo> comments) {
    return comments.stream().filter(c -> c.kind.equalsIgnoreCase(kind)).map(c -> c.text != null ? c.text : "").findAny();
  }
  
  private boolean hasComment(String kind, Collection<CommentInfo> comments) {
    return getComment(kind, comments).isPresent();
  }
  
  
}
