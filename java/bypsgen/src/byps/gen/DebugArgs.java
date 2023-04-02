package byps.gen;

public class DebugArgs {

  // /////////////////////////////////////////////////////////////
  // DEBUG
  //

  @SuppressWarnings("unused")
  public static String[] bypstest_ser = new String[] {
      
  "-genrest.openapi-file", "../bypstest-ser/res/openapi.json",
  "-genrest.src-dir", "../bypstest-ser/src-ser",
  "-genrest.auth-basic", 
  "-genrest.auth-apikey", "cookie:JSESSIONID",
  "-genrest.server-url", "http://localhost:6080/bypstest-srv/bypsservlet/rest",

  "-genj.dir-ser", "../bypstest-ser/src-ser", "-genj.dir-ser-bin", "../bypstest-ser/src-ser-bin", "-genj.dir-ser-json", "../bypstest-ser-json/src",
  "-genj.dir-test", "../bypstest-ser/src-test",

  "-gencs.dir-ser", "../../csharp/bypstest-ser/src-ser", "-gencs.upfirst", "true",

  "-genjs.dest", "../bypstest-srv/WebContent/testser.js",

  "-gencpp.dir-api", "../../cpp/common/bypstest/bypstest-gen/api", "-gencpp.dir-impl", "../../cpp/common/bypstest/bypstest-gen/impl",
  "-gencs.dot-net-version", "4.5",

      // "-genc.pack.alias", "byps.sample1=IX",
      "-gencpp.max-fsize", "50000",

      // "-verbose",

      // "--packages",
      // "byps.test.api",
      // "byps.test.api.prim",
      // "byps.test.api.arr",
      // "byps.test.api.list",
      // "byps.test.api.map",
      // "byps.test.api.set",
      // "byps.test.api.inherit",
      // "byps.test.api.priv",
      // "byps.test.api.cons",
      // "byps.test.api.remote",
      // "byps.test.api.refs",
      // "byps.test.api.enu",
      // "byps.test.api.inl",
      // "byps.test.api.strm",
      // "byps.test.api.srvr",
      // "byps.test.api.ver",

      "--sourcepath", "../bypstest-api/src",

  // "-gen.changedmembers",
  };
  
  /**
   * EloixClient directory of IX-API.
   * BYPS-73
   */
  private static String IX_PROJECT_ROOT = "/home/wolfgang/git/ix-release20/ELOserver/EloixClient";
  
  /**
   * Debugging of IX-API generation.
   * BYPS-73
   */
  public static String[] byps_ix = new String[] {
      
      "--encoding", "UTF-8", 
      "--packages", ""
        + "de.elo.ix.client" 
        + ":de.elo.ix.client.feed" 
        + ":de.elo.ix.client.myelo" 
        + ":de.elo.ix.client.compatibility" 
        + ":de.elo.ix.client.notify" 
        + ":de.elo.ix.client.search" 
        + ":de.elo.ix.client.health" 
        + ":de.elo.ix.client.ldap" 
        + ":de.elo.ix.client.system" 
        + ":de.elo.ix.client.plugin" 
        + ":de.elo.ix.client.esearch" 
        + ":de.elo.ix.client.esearch.configpage" 
        + ":de.elo.ix.client.esearch.query" 
        + ":de.elo.ix.client.esearch.query.data" 
        + ":de.elo.ix.client.subs" 
        + ":de.elo.ix.client.fio" 
        + ":de.elo.ix.client.devents",
    
         "--sourcepath", 
           IX_PROJECT_ROOT + "/src-api" + ":" + IX_PROJECT_ROOT + "/src-api-gen",            
         "-allserials",
         "-onlyBRemotes",
         "-gen.changedmembers",
         "-ensureUIDs",

         "-genj.dir-ser",      IX_PROJECT_ROOT + "/src-byps",
         "-genj.dir-ser-json", IX_PROJECT_ROOT + "/src-byps",
         "-genj.dir-test",     IX_PROJECT_ROOT + "/src-byps",
         "-genjs.dest",        IX_PROJECT_ROOT + "/../EloixWar/json-api/ixbyps.js",
         "-genjs.suppress-const-classes",

         "-gencs.dir-ser",     IX_PROJECT_ROOT + "/../ELOixclientcs/EloixClientCS/src-ser",
         "-gencs.upfirst",     "false",

         "-gencs.rename-packages", "" 
            + "EloixClient.IndexServer=de.elo.ix.client" 
            + ";EloixClient.IndexServer.feed=de.elo.ix.client.feed" 
            + ";EloixClient.IndexServer.myelo=de.elo.ix.client.myelo" 
            + ";EloixClient.IndexServer.compatibility=de.elo.ix.client.compatibility" 
            + ";EloixClient.IndexServer.notify=de.elo.ix.client.notify" 
            + ";EloixClient.IndexServer.replication=de.elo.ix.client.fio" 
            + ";EloixClient.IndexServer.health=de.elo.ix.client.health" 
            + ";EloixClient.IndexServer.system=de.elo.ix.client.system" 
            + ";EloixClient.IndexServer.plugin=de.elo.ix.client.plugin" 
            + ";EloixClient.IndexServer.esearch=de.elo.ix.client.esearch" 
            + ";EloixClient.IndexServer.esearch.query=de.elo.ix.client.esearch.query" 
            + ";EloixClient.IndexServer.esearch.query.data=de.elo.ix.client.esearch.query.data",

//         "-gencpp.dir-api",    IX_PROJECT_ROOT + "/../ELOixclientcpp/src-ser/api",
//         "-gencpp.dir-impl",   IX_PROJECT_ROOT + "/../ELOixclientcpp/src-ser/impl",
        
         //"--classpath", getRTClassPath(),
         
         // EIX-2198: generate REST API
         "-genrest.openapi-file", IX_PROJECT_ROOT + "/../EloixWar/templates/openapi.json",
         "-genrest.src-dir", IX_PROJECT_ROOT + "/src-byps",
         "-genrest.server-url", "http://servername:port/ix-repository/rest",
         "-genrest.auth-apikey", "cookie:JSESSIONID",
         
         // EIX-2239: allow Basic-Authentication
         "-genrest.auth-basic",
         "-genrest.auth-bearer"

  };

  public static String[] byps_ix_serAll = new String[] {

      //"-genj.dir-ser", "d:\\java\\workspace_git\\Eloix-byps\\src",

      // "-genj.dir-ser-bin", "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-bin",
      // "-genj.dir-ser-json",
      // "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-json",
      //
      // "-gencs.dir-ser", "D:\\dev\\BYPS2\\csharp\\byps\\byps_ix_ser\\src-ser",
      // "-gencs.upfirst", "false",
      //

      "-gencpp.dir-api", "d:\\git\\ELOixclientcpp\\src-ser\\api", "-gencpp.dir-impl", "d:\\git\\ELOixclientcpp\\src-ser\\impl", "-gencpp.max-fsize", "50000",

      //"-genjs.dest", "d:\\git\\ELOindexserver\\EloixWar\\json-api\\ixbyps.js", "-genjs.suppressConstClasses",

      "-allserials", "-onlyBRemotes", "-gen.changedmembers",

      // "-verbose",

      "-ensureUIDs",

      "--packages", "de.elo.ix.client;de.elo.ix.client.feed;de.elo.ix.client.compatibility;de.elo.ix.client.notify",

      "--sourcepath", "d:\\git\\ELOindexserver\\Eloix-api\\src;d:\\git\\ELOindexserver\\Eloix-api\\src-gen",

      "--classpath", "d:\\java\\lib\\EloixClient\\EloixClient.jar;d:\\java\\lib\\EloixClient\\javautils.jar" };

  public static String[] byps_ix_ser_eventbus = new String[] {

  "-genj.dir-ser", "d:\\java\\workspace_git\\Eloix-byps\\src",

      // "-genj.dir-ser-bin", "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-bin",
      // "-genj.dir-ser-json",
      // "d:\\dev\\BYPS2\\java\\byps-ix-ser\\src-ser-json",
      //
      // "-gencs.dir-ser", "D:\\dev\\BYPS2\\csharp\\byps\\byps_ix_ser\\src-ser",
      // "-gencs.upfirst", "false",
      //
      // "-gencpp.dir-api",
      // "d:\\dev\\BYPS2\\cpp-msvc\\byps\\bypstest\\byps_ix_ser\\api",
      // "-gencpp.dir-impl",
      // "d:\\dev\\BYPS2\\cpp-msvc\\byps\\bypstest\\byps_ix_ser\\impl",
      // //"-genc.pack.alias", "byps.sample1=IX",
      // "-gencpp.max-fsize", "50000",

      //"-genjs.dest", "d:\\git\\ELOindexserver\\EloixWar\\json-api\\ixbyps.js",

      // "-verbose",

      "-ensureUIDs", "-onlyBRemotes", "-allserials",

      "--packages", "de.elo.ix.client",

      "--sourcepath", "d:\\git\\ELOindexserver\\Eloix-api\\src-eventbus;d:\\git\\ELOindexserver\\Eloix-api\\src;d:\\git\\ELOindexserver\\Eloix-api\\src-gen",

      "--classpath", "d:\\java\\lib\\EloixClient\\EloixClient.jar;d:\\java\\lib\\EloixClient\\javautils.jar" };


}
