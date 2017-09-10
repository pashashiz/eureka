package com.ps.eureka;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExampleEurekaServer {

    public static void main(String[] args) throws Exception {
        System.setProperty("eureka.client.props", "example-eureka-client");
        System.setProperty("eureka.server.props", "example-eureka-server");
        Path war = resource("eureka-server-1.8.0.war");
        Server server = new Server(8081);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/eureka");
        webapp.setWar(war.toAbsolutePath().toString());
        server.setHandler(webapp);
        server.start();
    }

    private static Path resource(String resource) throws URISyntaxException {
        URL url = ExampleEurekaServer.class.getClassLoader().getResource(resource);
        return Paths.get(url.toURI());
    }
}
