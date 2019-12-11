package byps.gen.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import byps.gen.api.CommentInfo;

public class JavadocCommentParser {
  
  private final String comment;
  private int currentIndex;
  private List<CommentInfo> cinfos = new ArrayList<>();
  
  public static List<CommentInfo> parse(String commentInfos) {
    if (commentInfos != null) {
      commentInfos = commentInfos.trim();
      
      if (!commentInfos.isEmpty()) {
        JavadocCommentParser me = new JavadocCommentParser(commentInfos);
        me.doit();
        List<CommentInfo> ret = me.cinfos;
        ret.sort((a,b) -> a.kind.compareTo(b.kind));
        return me.cinfos;
      }
    }
    return Collections.emptyList();
  }
  
  private JavadocCommentParser(String commentInfos) {
    this.comment = commentInfos;
    this.currentIndex = 0;
  }

  private int skipWhitespace(String s, int i) {
    while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++;
    return i;
  }
  
  private int findWhitespace(String s, int i) {
    while (i < s.length() && !Character.isWhitespace(s.charAt(i))) i++;
    return i;
  }

  private int findNextLine(String s, int i) {
    int p = i < s.length() ? s.indexOf('\n', i) : -1;
    int q = p >= 0 ? p + 1 : s.length();
    return skipWhitespace(s, q);
  }
  
  private boolean isTag(String s, int i) {
    return i < s.length() && s.charAt(i) == '@';
  }
  
  private int findNextTag(String s, int i) {
    while ((i = findNextLine(s, i)) < s.length()) {
      if (isTag(s, i)) break;
    }
    return i;
  }
  
  private int findSummaryEnd(String s, int i) {
    i = findNextLine(s, i);
    int p = s.lastIndexOf('.', i-1);
    return p >= 0 ? skipWhitespace(s, p+1) : i;
  }

  private boolean parseCommentTag() {
    CommentInfo commentInfo = null;
    int startIndex = currentIndex;
    
    if (isTag(comment, startIndex)) {
      int endIndex = findWhitespace(comment, startIndex);
      String kind = comment.substring(startIndex, endIndex).trim();
         
      startIndex = endIndex;
      endIndex = findNextTag(comment, startIndex);
      String text = comment.substring(startIndex, endIndex).trim();
      
      currentIndex = endIndex;
      commentInfo = new CommentInfo(kind, text);
    }
    
    boolean ret = commentInfo != null;
    if (ret) {
      add(commentInfo);
    }
    
    return ret;
  }
  
  private boolean parseSummary() {
    int startIndex = currentIndex;
    int endIndex = findSummaryEnd(comment, startIndex);
    String summary = comment.substring(startIndex, endIndex).trim();
    boolean ret = !summary.isEmpty();
    if (ret) {
      add(new CommentInfo(CommentInfo.KIND_SUMMARY, summary));
      currentIndex = endIndex;
    }
    return ret;
  }
  
  private boolean parseRemarks() {
    int startIndex = currentIndex;
    int endIndex = findNextTag(comment, startIndex);
    String remarks = comment.substring(startIndex, endIndex).trim();
    boolean ret = !remarks.isEmpty();
    if (ret) {
      add(new CommentInfo(CommentInfo.KIND_REMARKS, remarks));
      currentIndex = endIndex;
    }
    return ret;
  }
  
  private void add(CommentInfo cinfo) {
    cinfos.add(cinfo);
  }
  
  private void doit() {
      
    if (!parseCommentTag()) {
      parseSummary();
    }
    
    if (!parseCommentTag()) {
      parseRemarks();
    }
    
    while (parseCommentTag()) {
      // breaks if no more tags found
    }
    
  }

}
