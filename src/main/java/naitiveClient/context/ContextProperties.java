package naitiveClient.context;

import uk.co.bbc.contextsupplier.PropertyTemplate;
import uk.co.bbc.contextsupplier.PropertyValue;

import static uk.co.bbc.contextsupplier.PropertyTemplate.ofInteger;
import static uk.co.bbc.contextsupplier.PropertyTemplate.ofString;

public class ContextProperties {

    public enum IntegerProperty implements PropertyValue<Args, Integer> {
        HTTP_PORT_NUM(ofInteger("http port number", Args::getHttpPort, "HttpPort")),
        HTTPS_PORT_NUM(ofInteger("https port number", Args::getHttpsPort, "HttpsPort")),
        MAX_RETRIES(ofInteger("max_retries", Args::getMaxRetries, "MaxRetries")),
        ;

        private final PropertyTemplate<Args, Integer> input;

        IntegerProperty(PropertyTemplate<Args, Integer> input) {
            this.input = input;
        }
        @Override public PropertyTemplate<Args, Integer> get() { return input; }
    }

    public enum StringProperty implements PropertyValue<Args, String> {
        SERVER_CERT(ofString("server cert", Args::getServerCert, "ServerCert")),
        SERVER_CERT_PASS(ofString("server cert pass", Args::getServerCertPass, "ServerCertPass")),
        CLIENT_CERT(ofString("client cert", Args::getServerCert, "ServerCert")),
        CLIENT_CERT_PASS(ofString("client cert pass", Args::getServerCertPass, "ServerCertPass")),
        TRUST_STORE(ofString("trust store", Args::getTrustStore, "TrustStore")),
        TRUST_STORE_PASS(ofString("trust store pass", Args::getTrustStorePass, "TrustStorePass")),
        HOSTNAME(ofString("hostname", Args::getHostname, "Hostname")),
        BIND(ofString("bind", Args::getBind, "Bind")),
        HEALTHCHECK_SECRET(ofString("healthcheck secret", Args::getHealthCheckSecret, "HealthcheckSecret")),

        DYNAMO_TABLE(ofString("dynamodb table", Args::getDynamoTable, "AvailabilityDocumentsDynamoDBTableName")),
        ;

        private final PropertyTemplate<Args, String> input;
        
        StringProperty(PropertyTemplate<Args, String> input) {
            this.input = input;
        }
        @Override public PropertyTemplate<Args, String> get() { return input; }
    }
}