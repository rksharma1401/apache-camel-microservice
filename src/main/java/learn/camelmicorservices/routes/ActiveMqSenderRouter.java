package learn.camelmicorservices.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
 
	@Override
	public void configure() throws Exception {
int i=0;
		from("timer:activemq-timer?period=5000").transform().constant("my message"+(++i) ).log("${body}").to("activemq:my-queue");

	}
}
