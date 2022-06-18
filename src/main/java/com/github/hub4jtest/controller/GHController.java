package com.github.hub4jtest.controller;

import com.github.hub4jtest.util.Authenticator;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GHController {

    @Autowired
    Authenticator authenticator;

    @GetMapping("/health")
    public String health() {
        return "working";
    }

    @PostMapping("/repo")
    public void createRepo(@RequestBody String repoName) throws IOException {
        GitHub github = null;
        try {
            github = authenticator.isAuthenticated();
        } catch (Exception e) {
            throw new RuntimeException("exception occured");
        }
        GHRepository ghRepository = github
                .createRepository(repoName)
                .gitignoreTemplate("Java")
                .owner("rpeb")
                .private_(true)
                .licenseTemplate("mit")
                .create();
        github.getRepository("rpeb/one").delete();
        github.getRepository("rpeb/two").delete();
    }
}
