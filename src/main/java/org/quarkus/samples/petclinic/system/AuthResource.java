package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class AuthResource {
    
    @Inject
    TemplatesLocale templates;

    @GET
    @Path("/login.html")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance showLoginPage() {
        return templates.login(false);
    }

    @GET
    @Path("/login-error.html")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance showLoginErrorPage() {
        return templates.login(true);
    }

}
