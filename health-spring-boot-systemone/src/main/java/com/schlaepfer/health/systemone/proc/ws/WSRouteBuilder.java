package com.schlaepfer.health.systemone.proc.ws;

import static com.schlaepfer.health.commons.Routes.id;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.systemone.proc.ws.model.IncrementRequest;
import com.schlaepfer.health.systemone.proc.ws.model.IncrementResponse;

@Component
public class WSRouteBuilder extends RouteBuilder {

	private static final String ROUTE_LABEL = "systemone_webservice";

	@Override
	public void configure() throws Exception {
		JaxbDataFormat jaxb = new JaxbDataFormat(IncrementRequest.class.getPackage().getName());

		final String routeId = id(WSRouteBuilder.class, ROUTE_LABEL);

		// @formatter:off 
        from("spring-ws:rootqname:{http://ws.eu.hcnet.biz/increment}incrementRequest?endpointMapping=#endpointMapping")
            .routeId(routeId)
        	.unmarshal(jaxb)
            .process(new IncrementProcessor())
            .marshal(jaxb);
        // @formatter:on 
	}

	private static final class IncrementProcessor implements Processor {
		public void process(Exchange exchange) throws Exception {
			IncrementRequest request = exchange.getIn().getBody(IncrementRequest.class);
			IncrementResponse response = new IncrementResponse();
			int result = request.getInput() + 1; // increment input value
			response.setResult(result);
			exchange.getOut().setBody(response);
		}
	}
}
