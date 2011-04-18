package cxf.test.hw.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:9000/helloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("Server started");        
        // END SNIPPET: publish
    	
    	// ALTERNATIVE CODE
    	//HelloWorldImpl implementor = new HelloWorldImpl();
    	//JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
    	//svrFactory.setServiceClass(HelloWorld.class);
    	//svrFactory.setAddress("http://localhost:9000/helloWorld");
    	//svrFactory.setServiceBean(implementor);
    	//svrFactory.getInInterceptors().add(new LoggingInInterceptor());
    	//svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
    	//svrFactory.create();
    }

    public static void main(String args[]) throws Exception {
    	new Server();
    	// Problem using this code in a executable JAR.
    	// Spring can't find the XML http://cxf.apache.org/jaxws  
    	//SpringBusFactory bf = new SpringBusFactory();
        //Bus bus = bf.createBus();
        System.out.println("Server ready...");
        System.out.println("To stop the server, push the 'Q' key !");
        while(System.in.read()!='q' && System.in.read()!='Q'){
        	Thread.sleep(100);
        	// Continue
        }
        System.out.println("Server exiting");
        System.exit(0);        
    }

}
