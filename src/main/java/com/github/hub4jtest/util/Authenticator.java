package com.github.hub4jtest.util;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Authenticator {
    @Value("${pat}")
    String personalAccessToken;

    public GitHub isAuthenticated() throws IOException {
        System.out.println("authentication request");
        return new GitHubBuilder().withOAuthToken(personalAccessToken).build();
    }
}
