import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocTes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\willi\\Documents\\GitHub\\Casco-Bay-Tracker\\src\\test\\resources\\C99\\chromedriver.exe");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 180);

        driver.get("https://www.marinetraffic.com");

        //wait for page load and accept cookies
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")));
        WebElement accept = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]"));
        accept.click();

        //open up menue
        WebElement ham = driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div/button"));
        ham.click();

        //log in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/button")));
        WebElement in = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/button"));
        in.click();

        //username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        WebElement user = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        user.sendKeys(args[0]);

        //password
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        pass.sendKeys(args[1]);

        //remember
        WebElement remember = driver.findElement(By.xpath("//*[@id=\"remembermeCheckbox\"]"));
        remember.click();

        //log in
        WebElement log = driver.findElement(By.xpath("//*[@id=\"login_form_submit\"]"));
        log.click();

        //wait for login complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"client-snackbar\"]/span")));
        //get fleet page
        driver.get("https://www.marinetraffic.com/en/data/?asset_type=vessels&columns=shipname,lat_of_latest_position,lon_of_latest_position,fleet&fleet_in|in|Casco%20Bay%20Lines|fleet_in=2163972");

        //wait for fleet page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"borderLayout_eGridPanel\"]/div[1]/div/div/div[1]/div[1]/div/div/div/div")));

        //get all 5 positions
        for (int i = 0; i < 5; i++) {
            WebElement lat = driver.findElement(By.xpath("//*[@id=\"borderLayout_eGridPanel\"]/div[1]/div/div/div[3]/div[3]/div/div/div["+(i+1)+"]/div[2]/div/div/div"));
            WebElement lon = driver.findElement(By.xpath("//*[@id=\"borderLayout_eGridPanel\"]/div[1]/div/div/div[3]/div[3]/div/div/div["+(i+1)+"]/div[3]/div/div/div"));
            System.out.println(lat.getText() + " " + lon.getText());
        }

        driver.close();
    }
}
