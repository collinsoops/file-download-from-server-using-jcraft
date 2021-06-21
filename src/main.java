
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


public class main {
    public static void main(String args[]) {
        String Username="";
        String hostname="10.42.0.152";
        int port=21;
        String password="";

        String copyFrom="C:/Users/Kenya Aliens IT/Desktop/sp";
        String copyTo="D:/Java/FTP";

        JSch jsch = new JSch();
        Session session = null;
        System.out.println("Trying to connect.....");
        try {
            session = jsch.getSession(Username,hostname,port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get(copyFrom, copyTo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
        System.out.println("Done !!");
    }
}