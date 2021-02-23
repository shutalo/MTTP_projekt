## MTTP_projekt

U projektu je u svrhu testiranja korištena igrica x-ox razvijena za android mobilni operacijski sustav. Aplikacija je napisana u kotlinu, a sučelje aplikacije se sastoji od 9 polja za unos simbola X i O te od prikaza omjera pobjeda. Za automatsko testiranje aplikacije koristi se Appium.


## Testiranje

Nakon uspješne instalacije i podešavanja varijabli korištenih za automatsko testiranje, slijedi pisanje testnih slučajeva, a zbog jednostavnosti napravit će se 5 testova. Prvo je potrebno napisati POM.xml datoteku sa svim potrebnim ovisnostima.

```
//POM.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>MTTPP</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId> io.appium </groupId>
            <artifactId> java-client </artifactId>
            <version> 7.4.1 </version>
        </dependency>
        <dependency>
            <groupId> org.testng </groupId>
            <artifactId> testng </artifactId>
            <version> 7.3.0 </version>
            <scope> test </scope>
        </dependency>
        <dependency>
            <groupId> org.apache.maven.plugins </groupId>
            <artifactId> maven-compiler-plugin </artifactId>
            <version> 3.8.1 </version>
            <type> maven-plugin </type>
        </dependency>
        <dependency>
            <groupId> org.apache.maven.plugins </groupId>
            <artifactId> maven-surefire-report-plugin </artifactId>
            <version> 3.0.0-M5 </version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>LATEST</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId> org.apache.maven.plugins </groupId>
                <artifactId> maven-compiler-plugin </artifactId>
                <configuration>
                    <source> 1.8 </source>
                    <target> 1.8 </target>
                </configuration>
            </plugin>
            <plugin>
                <groupId> org.apache.maven.plugins </groupId>
                <artifactId> maven-surefire-plugin </artifactId>
                <version> 3.0.0-M5 </version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile> testng.xml </suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <properties>
        <maven.compiler.source>15</maven.compiler.source>
        <maven.compiler.target>15</maven.compiler.target>
    </properties>

</project>

```
Nakon što smo napisali POM.xml datoteku, potrebno je napisati testove, a klasa u kojoj su napisani zove se TestMobile. Da bi testna klasa funkcionirala potrebno je prvo definirati koji .apk se koristi, verziju i naziv emulatora, naziv platforme i postaviti Android Driver. Test provjerava nalaze li se određeni elementi na korisničkom sučelju, a pronalaženje se odvija pomoću xpatha koji je pronađen korištenjem Appium Session-a. Za slučaj da traženi element nije odmah dostupan, na Android driver-u je podešeno implicitno čekanje u trajanju od 10 sekundi.
```

//TestMobile.java
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations. BeforeClass ;
import org.testng.annotations. Test ;


public class TestMobile {
    AndroidDriver driver ;

    @BeforeClass ()
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "app" , "C:\\Users\\Luka\\Desktop\\MTTP_projekt-main\\app\\build\\outputs\\apk\\debug\\app-debug.apk" );
        capabilities.setCapability( "VERSION" , "9.0" );
        capabilities.setCapability( "deviceName" , "emulator" );
        capabilities.setCapability( "platformName" , "Android" );
        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities);
        driver.manage().timeouts().implicitlyWait( 10 , TimeUnit. SECONDS );
    }

    @Test
    public void testCal() throws Exception {
        MobileElement e11= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[1]\n" ));
        e11.click();

        MobileElement e12= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[2]\n" ));
        e12.click();

        MobileElement e13= (MobileElement)
                driver.findElement(By.xpath ( "\t\n" +
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[3]\n" ));
        e13.click();

        MobileElement e14= (MobileElement)
                driver.findElement(By.xpath ( "\t\n" +
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[4]" ));
        e14.click();

        MobileElement e15= (MobileElement)
                driver.findElement(By.xpath ( "\t\n" +
                        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[5]" ));
        e15.click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    public void teardown(){
        driver .quit();
    }
}
now

```
Također nam je potrebna testng.xml datoteka u kojoj se određuje naziv testa i klasa koju pozivamo.
```

//testng.xml
<?xml version ="1.0" encoding ="UTF-8"?>
        <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name ="AllTestsSuite">
    <test name ="XOX">
        <classes>
            <class name ="TestMobile"/>
        </classes>
    </test>
</suite>
```

Za generiranje izvještaja korištena je naredba:
```
mvn test (cntrl + enter)
```

Aplikacija koja je testirana u projektu nalazi se u repozitoriju kao i izvještaj o uspješnosti testova. Također se nalazi i aplikacija zapakirana u zip file.
