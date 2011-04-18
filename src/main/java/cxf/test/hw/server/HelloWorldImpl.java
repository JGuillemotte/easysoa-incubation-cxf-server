package cxf.test.hw.server;

import javax.jws.WebService;

@WebService(endpointInterface = "cxf.test.hw.server.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }

	public String repeatAfterMe(String text, int iterations) {
        System.out.println("repeatAfterMe called");		
		StringBuffer st = new StringBuffer();
		for(int i = 0; i<iterations; i++){
			if(st.length() > 0){
				st.append(" ; ");
			}
			st.append(text);
		}
		return st.toString();
	}
}
