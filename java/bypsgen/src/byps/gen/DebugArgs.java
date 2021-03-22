package byps.gen;

public class DebugArgs {

  // /////////////////////////////////////////////////////////////
  // DEBUG
  //

  @SuppressWarnings("unused")
  public static String[] bypstest_ser = new String[] {
      
  "-genrest.openapi-dir", "../bypstest-api",

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
