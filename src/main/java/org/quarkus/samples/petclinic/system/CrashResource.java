package org.quarkus.samples.petclinic.system;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/oups")
public class CrashResource {
    
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_HTML)
    public String triggerException() {
		throw new RuntimeException(
				"Expected: controller used to showcase what " + "happens when an exception is thrown");
	}

}
