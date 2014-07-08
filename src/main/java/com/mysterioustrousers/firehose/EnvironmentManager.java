package com.mysterioustrousers.firehose;



import java.util.HashMap;



public class EnvironmentManager {
  // temporary way for IP address
  public static String localIP = "192.168.1.19";

  // region: Singleton Implementation

  private static EnvironmentManager s_instance = null;


  public static EnvironmentManager getInstance() {
    if (s_instance == null) {
      s_instance = new EnvironmentManager();
    }
    return s_instance;
  }

  // endregion



  private HashMap<FHApplication, HashMap<Environment, String>> _domains;

  private Environment       _env;
  private ServerEnvironment _serverEnv;



  private EnvironmentManager() {
    // region: Setup Domains

    _domains = new HashMap<FHApplication, HashMap<Environment, String>>();

    HashMap<Environment, String> apiDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "api.firehoseapp.com");
    apiDomains.put(Environment.PRODUCTION, "api.firehoseapp.com");
    _domains.put(FHApplication.API, apiDomains);

    HashMap<Environment, String> browserDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "beta.firehoseapp.com");
    apiDomains.put(Environment.PRODUCTION, "firehoseapp.com");
    _domains.put(FHApplication.BROWSER, browserDomains);

    HashMap<Environment, String> billingDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "billing.firehoseapp.com");
    apiDomains.put(Environment.PRODUCTION, "billing.firehoseapp.com");
    _domains.put(FHApplication.BILLING, billingDomains);

    HashMap<Environment, String> filesDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "frh.io");
    apiDomains.put(Environment.PRODUCTION, "frh.io");
    _domains.put(FHApplication.FILES, filesDomains);

    HashMap<Environment, String> marketingDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "beta.firehosedesk.com");
    apiDomains.put(Environment.PRODUCTION, "firehosedesk.com");
    _domains.put(FHApplication.MARKETING, marketingDomains);

    HashMap<Environment, String> settingsDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "beta_settings.firehoseapp.com");
    apiDomains.put(Environment.PRODUCTION, "settings.firehoseapp.com");
    _domains.put(FHApplication.SETTINGS, settingsDomains);

    HashMap<Environment, String> tweetLongerDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "beta_tl.frh.io");
    apiDomains.put(Environment.PRODUCTION, "tl.frh.io");
    _domains.put(FHApplication.TWEET_LONGER, tweetLongerDomains);

    HashMap<Environment, String> kbDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "firehosesupport.com");
    apiDomains.put(Environment.PRODUCTION, "firehosehelp.com");
    _domains.put(FHApplication.KB, kbDomains);

    HashMap<Environment, String> chatBrowserDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "???");
    apiDomains.put(Environment.PRODUCTION, "???");
    _domains.put(FHApplication.CHAT_BROWSER, chatBrowserDomains);

    HashMap<Environment, String> chatMarketingDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "firehosechat.com");
    apiDomains.put(Environment.PRODUCTION, "firehosechat.com");
    _domains.put(FHApplication.CHAT_MARKETING, chatMarketingDomains);

    HashMap<Environment, String> chatServerDomains = new HashMap<Environment, String>();
    apiDomains.put(Environment.DEV, "localhost");
    apiDomains.put(Environment.TEST, "localhost");
    apiDomains.put(Environment.BETA, "chat.firehoseapp.com");
    apiDomains.put(Environment.PRODUCTION, "chat.firehoseapp.com");
    _domains.put(FHApplication.CHAT_SERVER, chatServerDomains);

    // endregion

    this.setEnvironment(Environment.DEV);
    this.setServerEnvironment(ServerEnvironment.LOCAL);
  }



  public String getServiceToken() {
    return null; // TODO: Implement
  }


  public String getBaseURL(FHApplication app) {
    return this.getBaseURL(app, this.getEnvironment(), this.getServerEnvironment());
  }


  public String getBaseURL(FHApplication app, Environment env, ServerEnvironment serverEnv) {
    return ((env.ordinal() < Environment.BETA.ordinal() || app == FHApplication.KB) ? "http://" : "https://")
           + _domains.get(app).get(env)
           + this.getPort(app, env, serverEnv);
  }


  private String getPort(FHApplication app, Environment env, ServerEnvironment serverEnv) {
    if (env.ordinal() > Environment.TEST.ordinal()) {
      return "";
    }
    if (app == FHApplication.CHAT_SERVER) {
      return ":8080";
    }

    return ":" + String.valueOf(this.getApplicationTypeNumber(app))
           + String.valueOf(serverEnv.ordinal())
           + String.valueOf(env.ordinal())
           + String.valueOf(app.ordinal());
  }


  private int getApplicationTypeNumber(FHApplication app) {
    switch (app) {
      case API:
      case BILLING:
      case FILES:
      case CHAT_SERVER:
        return 3;
      default:
        return 4;
    }
  }



  // region: Getters & Setters


  public Environment getEnvironment() {
    return _env;
  }


  public void setEnvironment(Environment env) {
    _env = env;
  }


  public ServerEnvironment getServerEnvironment() {
    return _serverEnv;
  }


  public void setServerEnvironment(ServerEnvironment serverEnv) {
    _serverEnv = serverEnv;
  }


  // endregion
}