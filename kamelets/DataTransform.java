import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Configuration
@BindToRegistry("DataTransform")
public class DataTransform implements Processor {

    public void process(Exchange exchange) throws Exception {
        String source = exchange.getProperty("admFilePath", String.class);
        exchange.getIn().setBody(source);
    }
}