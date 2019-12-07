package byps.gen.xml;

import java.util.List;

import byps.gen.api.CommentInfo;

public class JavadocCommentParser {
  
  private final String comment;
  private int currentIndex;
  
  public static void parse(String commentInfos, List<CommentInfo> cinfos) {
    if (commentInfos != null) {
      commentInfos = commentInfos.trim();
      
      if (!commentInfos.isEmpty()) {
        JavadocCommentParser me = new JavadocCommentParser(commentInfos);
        me.doit(cinfos);
      }
    }
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

  private boolean parseCommentTag(List<CommentInfo> cinfos) {
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
      cinfos.add(commentInfo);
    }
    
    return ret;
  }
  
  private boolean parseSummary(List<CommentInfo> cinfos) {
    int startIndex = currentIndex;
    int endIndex = findSummaryEnd(comment, startIndex);
    String summary = comment.substring(startIndex, endIndex).trim();
    boolean ret = !summary.isEmpty();
    if (ret) {
      cinfos.add(new CommentInfo(CommentInfo.KIND_SUMMARY, summary));
      currentIndex = endIndex;
    }
    return ret;
  }
  
  private boolean parseRemarks(List<CommentInfo> cinfos) {
    int startIndex = currentIndex;
    int endIndex = findNextTag(comment, startIndex);
    String remarks = comment.substring(startIndex, endIndex).trim();
    boolean ret = !remarks.isEmpty();
    if (ret) {
      cinfos.add(new CommentInfo(CommentInfo.KIND_REMARKS, remarks));
      currentIndex = endIndex;
    }
    return ret;
  }
  
  private void doit(List<CommentInfo> cinfos) {
      
    if (!parseCommentTag(cinfos)) {
      parseSummary(cinfos);
    }
    
    if (!parseCommentTag(cinfos)) {
      parseRemarks(cinfos);
    }
    
    while (parseCommentTag(cinfos)) {
      // breaks if no more tags found
    }
    
  }

}
