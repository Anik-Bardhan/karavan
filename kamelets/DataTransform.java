import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import java.util.*;
import java.io.File;

@Configuration
@BindToRegistry("DataTransform")
public class DataTransform implements Processor {

    public void process(Exchange exchange) throws Exception {
        //Map headers = exchange.getIn().getHeaders();
        //Adm file path: {admFilePath=sample, CamelFileExchangeFile=RemoteFile[DPS_Sample.csv]}
        String admFilePath = exchange.getProperty("admFilePath", String.class);
        String body = exchange.getIn().getBody(String.class);
        Map<String, Object> headers = exchange.getProperties();
        System.out.println("Adm file path: " + admFilePath);

        File file = new File(admFilePath);
        Scanner sc = new Scanner(file);
 
        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
        
        exchange.getIn().setBody("Hello from kamelet");
        
    }
}