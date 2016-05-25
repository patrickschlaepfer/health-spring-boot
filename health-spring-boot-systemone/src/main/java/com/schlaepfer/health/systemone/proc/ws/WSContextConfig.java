package com.schlaepfer.health.systemone.proc.ws;

import org.apache.camel.component.spring.ws.bean.CamelEndpointMapping;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration
public class WSContextConfig implements InitializingBean {

    private static final String LOCATION_URL = "http://localhost:9000/api/increment";
    private static final String INCREMENT_XSD = "increment.xsd";

    /*
     * Endpoint mappings
     */
    @Bean(name = "endpointMapping")
    public CamelEndpointMapping camelEndpointMapping() {
        CamelEndpointMapping endpointMapping = new CamelEndpointMapping();
        EndpointInterceptor[] interceptors = { validatingInterceptor(), loggingInterceptor() };
        endpointMapping.setInterceptors(interceptors);
        return endpointMapping;
    }

    @Bean(name = "validatingInterceptor")
    public PayloadValidatingInterceptor validatingInterceptor() {
        PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
        payloadValidatingInterceptor.setSchema(new ClassPathResource(INCREMENT_XSD));
        payloadValidatingInterceptor.setValidateRequest(true);
        payloadValidatingInterceptor.setValidateResponse(true);
        return payloadValidatingInterceptor;
    }

    @Bean(name = "loggingInterceptor")
    public PayloadLoggingInterceptor loggingInterceptor() {
        return new PayloadLoggingInterceptor();
    }

    @Bean(name = "xsd")
    public SimpleXsdSchema simpleXsdSchema() {
        SimpleXsdSchema simpleXsdSchema = new SimpleXsdSchema();
        simpleXsdSchema.setXsd(new ClassPathResource(INCREMENT_XSD));
        return simpleXsdSchema;
    }

    /*
     * WSDL exposure
     */
    @Bean(name = "increment")
    public DefaultWsdl11Definition dealCommitedDestination() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setSchema(simpleXsdSchema());
        wsdl11Definition.setLocationUri(LOCATION_URL);
        wsdl11Definition.setPortTypeName("increment");
        return wsdl11Definition;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub

    }

}
