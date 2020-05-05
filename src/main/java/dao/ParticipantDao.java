package dao;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ParticipantDao {
	@GET
    public String sayHello() {
        return "Hello, how are you?";
    }
}
