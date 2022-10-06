package vistra.test.energy;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import vistra.test.energy.controller.EnergyController;

@Component
public class JerseyAppConfig extends ResourceConfig{
    public JerseyAppConfig() {
    	register(EnergyController.class);
    }
}
