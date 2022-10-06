package vistra.energy.retailer;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import vistra.energy.retailer.controller.EnergyController;

@Component
public class JerseyAppConfig extends ResourceConfig{
    public JerseyAppConfig() {
    	register(EnergyController.class);
    }
}
