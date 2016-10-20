import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author yiwenren
 */
public class BaseTest {
    public WebDriver driver;
    private WebDriverWait wait;
    
    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }
    
    @After
    public void teardown(){
        driver.quit();
    }
    
    public void waitUntil(Predicate<WebDriver> predicate){
        wait.until(predicate);
    }
    
}