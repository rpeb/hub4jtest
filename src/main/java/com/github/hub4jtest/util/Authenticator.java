package com.github.hub4jtest.util;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class Authenticator {
    String tokenProperty = "src/main/resources/token.properties";
    Properties properties = PropertyFile.getPropertiesFromFile(tokenProperty);
    String personalAccessToken = properties.getProperty("pat");

    public GitHub isAuthenticated() throws IOException {
        return new GitHubBuilder().withOAuthToken(personalAccessToken).build();
    }
}
