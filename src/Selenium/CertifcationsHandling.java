package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CertifcationsHandling extends Base {

    public static void main(String[] args){


       DesiredCapabilities dc=DesiredCapabilities.chrome();

        //Accepting Insecure certification
        dc.acceptInsecureCerts();

        //Providing Capability for Insecure Certification
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        //Providing Capability for SSL Certification
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        ChromeOptions chr=new ChromeOptions();
        chr.merge(dc);

        setpropforChrome();
        WebDriver driver=new ChromeDriver(chr);
    }
}