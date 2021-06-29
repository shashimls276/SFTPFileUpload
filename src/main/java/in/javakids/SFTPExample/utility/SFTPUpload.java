package in.javakids.SFTPExample.utility;

import com.jcraft.jsch.*;
import org.springframework.stereotype.Component;

@Component
public class SFTPUpload {
    private String remoteHost = "34.93.60.131";
    private String username = "";
    private String password = "PASSWORD_HERE";

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts("/Users/ab68478/.ssh/");
        Session jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public void uploadFile(){
        ChannelSftp channelSftp = null;
        try {
            channelSftp = setupJsch();
            channelSftp.connect();
            String localFile = "src/main/resources/application.properties";
            String remoteDir = "/usr";
            channelSftp.put(localFile, remoteDir + "jschFile.txt");
            channelSftp.exit();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }

    }
}
