package config;


import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/creds.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
