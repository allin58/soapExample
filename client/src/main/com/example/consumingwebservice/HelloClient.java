package main.com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.ServiceRequest;
import com.example.consumingwebservice.wsdl.ServiceResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class HelloClient extends WebServiceGatewaySupport {

    public ServiceResponse getHello(String name) {

        ServiceRequest request = new ServiceRequest();
        request.setName(name);



        ServiceResponse response = (ServiceResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://www.example.org/HelloService"));

        return response;
    }

}
