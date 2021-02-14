package space.smarquardt.aws.profilemanager.sts.abstractor;

import java.time.Duration;

public record ConnectInformation(String tokenCode,String mfaDeviceArn, String roleArn, Duration sessionDuration,String profileName) {
}
