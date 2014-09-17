package com.mysterioustrousers.firehose;



import com.mysterioustrousers.net.InternetUtils;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.lang3.StringUtils;



public class EnvironmentManager {

  public static final String REMOTE_DEV_AND_TEST_DOMAIN_PROPERTY_NAME = "MT_FH_DEV_AND_TEST_DOMAIN";


  // region: Singleton Implementation

  private static EnvironmentManager s_instance = null;


  public static EnvironmentManager getInstance() {
    if (s_instance == null) {
      s_instance = new EnvironmentManager(false);
    }
    return s_instance;
  }


  private static EnvironmentManager s_remoteInstance         = null;
  private static String             s_remoteDevAndTestDomain = null;


  public static EnvironmentManager getRemoteInstance() {
    if (s_remoteInstance == null) {
      s_remoteInstance = new EnvironmentManager(true);
    }
    return s_remoteInstance;
  }

  // endregion



  private MultiKeyMap<Object, String> _domains;

  private Environment       _env;
  private ServerEnvironment _serverEnv;



  private EnvironmentManager(boolean isRemoteInstance) {
    // region: Setup Domains

    String devAndTestDomain = "localhost";

    if (isRemoteInstance) {
      String remoteDevAndTestDomain = System.getProperty(EnvironmentManager.REMOTE_DEV_AND_TEST_DOMAIN_PROPERTY_NAME, null);
      if (!StringUtils.isBlank(remoteDevAndTestDomain)) {
        devAndTestDomain = remoteDevAndTestDomain;
      }
    }

    _domains = new MultiKeyMap<Object, String>();

    _domains.put(FHApplication.API, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.API, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.API, Environment.BETA, "api.firehoseapp.com");
    _domains.put(FHApplication.API, Environment.PRODUCTION, "api.firehoseapp.com");

    _domains.put(FHApplication.BROWSER, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.BROWSER, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.BROWSER, Environment.BETA, "beta.firehoseapp.com");
    _domains.put(FHApplication.BROWSER, Environment.PRODUCTION, "firehoseapp.com");

    _domains.put(FHApplication.BILLING, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.BILLING, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.BILLING, Environment.BETA, "billing.firehoseapp.com");
    _domains.put(FHApplication.BILLING, Environment.PRODUCTION, "billing.firehoseapp.com");

    _domains.put(FHApplication.FILES, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.FILES, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.FILES, Environment.BETA, "frh.io");
    _domains.put(FHApplication.FILES, Environment.PRODUCTION, "frh.io");

    _domains.put(FHApplication.MARKETING, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.MARKETING, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.MARKETING, Environment.BETA, "beta.firehosedesk.com");
    _domains.put(FHApplication.MARKETING, Environment.PRODUCTION, "firehosedesk.com");

    _domains.put(FHApplication.SETTINGS, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.SETTINGS, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.SETTINGS, Environment.BETA, "beta_settings.firehoseapp.com");
    _domains.put(FHApplication.SETTINGS, Environment.PRODUCTION, "settings.firehoseapp.com");

    _domains.put(FHApplication.TWEET_LONGER, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.TWEET_LONGER, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.TWEET_LONGER, Environment.BETA, "beta_tl.frh.io");
    _domains.put(FHApplication.TWEET_LONGER, Environment.PRODUCTION, "tl.frh.io");

    _domains.put(FHApplication.KB, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.KB, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.KB, Environment.BETA, "firehosesupport.com");
    _domains.put(FHApplication.KB, Environment.PRODUCTION, "firehosehelp.com");

    _domains.put(FHApplication.CHAT_BROWSER, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.CHAT_BROWSER, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.CHAT_BROWSER, Environment.BETA, "beta.firehoseapp.com");
    _domains.put(FHApplication.CHAT_BROWSER, Environment.PRODUCTION, "app.firehosechat.com");

    _domains.put(FHApplication.CHAT_BILLING, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.CHAT_BILLING, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.CHAT_BILLING, Environment.BETA, "beta_billing.firehosechat.com");
    _domains.put(FHApplication.CHAT_BILLING, Environment.PRODUCTION, "billing.firehosechat.com");

    _domains.put(FHApplication.CHAT_MARKETING, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.CHAT_MARKETING, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.CHAT_MARKETING, Environment.BETA, "firehosechat.com");
    _domains.put(FHApplication.CHAT_MARKETING, Environment.PRODUCTION, "firehosechat.com");

    _domains.put(FHApplication.CHAT_SERVER, Environment.DEV, devAndTestDomain);
    _domains.put(FHApplication.CHAT_SERVER, Environment.TEST, devAndTestDomain);
    _domains.put(FHApplication.CHAT_SERVER, Environment.BETA, "chat.firehoseapp.com");
    _domains.put(FHApplication.CHAT_SERVER, Environment.PRODUCTION, "chat.firehoseapp.com");

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
           + _domains.get(app, env)
           + this.getPort(app, env, serverEnv);
  }


  private String getPort(FHApplication app, Environment env, ServerEnvironment serverEnv) {
    if (env.ordinal() > Environment.TEST.ordinal()) {
      return org.apache.commons.lang3.StringUtils.EMPTY;
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


  public boolean isURLAvailable(FHApplication app) {
    return InternetUtils.isURLAvailable(this.getBaseURL(app));
  }



  // region Getters/Setters


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