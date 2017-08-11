package naitiveClient.context;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.ExplicitBooleanOptionHandler;
import uk.co.bbc.contextsupplier.Arguments;

public class Args implements Arguments {



    @Option(name = "--debug", metaVar = "<BOOLEAN>",
            usage = "Error messages will include extra info like stack traces.", handler = ExplicitBooleanOptionHandler.class)
    private boolean debug  =  false;

    @Option(name = "--on-ec2", metaVar = "<BOOLEAN>",
            usage = "set to false if the component is not running on EC2", handler = ExplicitBooleanOptionHandler.class)
    private boolean onEc2  =  true;

    @Option(name = "--max-retries", metaVar = "<NUMBER>")
    private int maxRetries = 10;

    @Option(name = "--access-log", usage = "Set access log location or leave null for no access logging") private String accessLog;

    @Option(name = "--dynamo-table", metaVar = "<STRING>")
    private String dynamoTable;

    @Option(name = "--servercert", metaVar = "<FILE>", usage = "Server cert .p12 path.")
    private String serverCert;

    @Option(name = "--servercertpass", metaVar = "<FILE>", usage = "Server cert password.")
    private String serverCertPass;

    @Option(name = "--truststore", metaVar = "<FILE>", usage = "Trust store .jks path.")
    private String trustStore;

    @Option(name = "--truststorepass", metaVar = "<FILE>", usage = "Trust store password.")
    private String trustStorePass;

    @Option(name = "--hostname", metaVar = "<URI>", usage = "Hostname that should contain local IP address.", required = false) private String hostname;

    @Option(name = "--healthchecksecret", usage = "Health Check Secret for verbose response", required = false) private String healthCheckSecret;

    @Option(name = "--bind", metaVar = "<ADDRESS>", usage = "IP address to bind to.") private String bind = "127.0.0.1";

    @Option(name = "--port-http", metaVar = "<PORT>", usage = "Port to bind to.") private int httpPort = 7080;

    @Option(name = "--port-https", metaVar = "<PORT>", usage = "Port to bind to.") private int httpsPort = 8443;

    @Option(name = "--clientcert", metaVar = "<FILE>", usage = "Client cert .p12 path.") private String clientCert;

    @Option(name = "--clientcertpass", metaVar = "<FILE>", usage = "Client cert password.") private String clientCertPass;



    public boolean isOnEc2() {
        return onEc2;
    }

    String getServerCert() {
        return serverCert;
    }

    String getServerCertPass() {
        return serverCertPass;
    }

    public String getTrustStore() {
        return trustStore;
    }

    public String getTrustStorePass() {
        return trustStorePass;
    }

    public boolean isDebug() {
        return debug;
    }

    String getDynamoTable() {
        return dynamoTable;
    }

    String getHealthCheckSecret() {
        return healthCheckSecret;
    }

    String getAccessLog() { return this.accessLog; }

    String getHostname() { return this.hostname; }

    String getBind() {
        return bind;
    }

    int getHttpPort() {
        return httpPort;
    }

    int getHttpsPort() {
        return httpsPort;
    }

    int getMaxRetries() {
        return maxRetries;
    }

    public String getClientCertPass() {
        return this.clientCertPass;
    }

    public String getClientCert() {
        return this.clientCert;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
