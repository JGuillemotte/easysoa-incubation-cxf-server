package cxf.test.hw.server;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

    String sayHi(@WebParam(name="text") String text);

    String repeatAfterMe(@WebParam(name="text") String text, @WebParam(name="iterations") int iterations);
}
