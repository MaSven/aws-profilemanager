package space.smarquardt.aws.profilemanager.sts.abstractor.impl;

import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.StsClientBuilder;
import software.amazon.awssdk.services.sts.auth.StsAssumeRoleCredentialsProvider;
import software.amazon.awssdk.services.sts.auth.StsGetSessionTokenCredentialsProvider;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.AssumeRoleResponse;
import software.amazon.awssdk.services.sts.model.GetSessionTokenRequest;
import software.amazon.awssdk.services.sts.model.GetSessionTokenResponse;
import space.smarquardt.aws.profilemanager.applicationinfo.ApplicationInfo;
import space.smarquardt.aws.profilemanager.sts.abstractor.ConnectInformation;
import space.smarquardt.aws.profilemanager.sts.abstractor.Sts;

public final class StsImpl implements Sts {



    private void changeProfile(ConnectInformation connectInformation){
        StsClient stsClient = StsClient.builder().build();

        AssumeRoleRequest assumeRoleRequest = AssumeRoleRequest.builder()
                .roleArn(connectInformation.roleArn())
                .roleSessionName(ApplicationInfo.applicatioName()+connectInformation.profileName())
                .serialNumber(connectInformation.mfaDeviceArn())
                .tokenCode(connectInformation.tokenCode())
                .durationSeconds(connectInformation.sessionDuration().toSecondsPart())
                .build();
        AssumeRoleResponse  response = stsClient.assumeRole(assumeRoleRequest);
        




    }

}
