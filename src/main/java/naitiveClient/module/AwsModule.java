package naitiveClient.module;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.util.EC2MetadataUtils;
import dagger.Module;
import dagger.Provides;
import naitiveClient.context.Args;
import naitiveClient.context.ContextProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.bbc.contextsupplier.ContextSupplier;
import uk.co.bbc.ec2userdata.UserDataParser;

import javax.inject.Singleton;
import java.io.IOException;

@Module
public class AwsModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsModule.class);

    @Provides
    public AmazonSQS provideAmazonSQS(Region region) {
        return region.createClient(AmazonSQSClient.class, null, null);
    }

    @Provides
    public AmazonSNS provideAmazonSNS(Region region) {
        return region.createClient(AmazonSNSClient.class, null, null);
    }

    @Provides
    public AmazonS3 provideAmazonS3(Region region) { return region.createClient(AmazonS3Client.class, null, null); }

    @Provides @Singleton
    public UserDataParser provideUserDataParser(Args args) {
        try {
            if (args.isOnEc2())
                return new UserDataParser(EC2MetadataUtils.getUserData());
            else
                return new UserDataParser("");
        } catch (IOException | AmazonClientException ex) {
            LOGGER.error("UserData not accessible", ex);
            throw new RuntimeException("UserData could not be accessed", ex);
        }
    }

    @Provides
    public Region provideRegion(Args args) {
        return args.isOnEc2() ? Regions.getCurrentRegion() : Region.getRegion(Regions.EU_WEST_1);
    }

    @Provides
    public DynamoDB provideDynamoDB(Region region, ContextSupplier<Args> supplier) {
        Integer maxRetries = supplier.get(ContextProperties.IntegerProperty.MAX_RETRIES);
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setMaxErrorRetry(maxRetries);

        AmazonDynamoDBClient client = region.createClient(AmazonDynamoDBClient.class, null, clientConfiguration);
        return new DynamoDB(client);
    }
}