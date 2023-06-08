package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void selectMenu(String showAllDesktops) {

        driver.get("http://tutorialsninja.com/demo/index.php?");
        // Click on the menu

        // Close the browser
        driver.quit();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?");//url

        // Mouse hover on "Desktops" tab and click
        WebElement desktopsTab = driver.findElement(By.linkText("Desktops"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsTab).perform();
        desktopsTab.click();

        // Click on "Show All Desktops" menu
        selectMenu("Show All Desktops");
        driver.findElement(By.xpath("\"//a[contains(text(),'Desktops')]")).click();
        // Verify the text 'Desktops'
        WebElement desktopsHeading = driver.findElement(By.cssSelector("h2.product-filter-heading"));
        Assert.assertEquals(desktopsHeading.getText(), "Desktops");
    }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
            // Open the base URL
            driver.get("http://tutorialsninja.com/demo/index.php");
            // Mouse hover on "Laptops & Notebooks" Tab and click
            WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[contains(text(), 'Laptops & Notebooks')]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(laptopsAndNotebooksTab).perform();
            laptopsAndNotebooksTab.click();

            // Call selectMenu method and pass the menu = "Show All Laptops & Notebooks"
            selectMenu("Show All Laptops & Notebooks");

            // Verify the text 'Laptops & Notebooks'
            WebElement laptopsAndNotebooksHeading = driver.findElement(By.xpath("//h2[contains(text(), 'Laptops & Notebooks')]"));
            Assert.assertEquals(laptopsAndNotebooksHeading.getText(), "Laptops & Notebooks");
        }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        // Open the base URL
        driver.get("http://tutorialsninja.com/demo/index.php");

        // Mouse hover on "Components" Tab and click
        WebElement componentsTab = driver.findElement(By.linkText("Components"));
        Actions actions = new Actions(driver);
        actions.moveToElement(componentsTab).perform();
        componentsTab.click();

        // Call selectMenu method and pass the menu = "Show All Components"
        selectMenu("Show All Components");

        // Verify the text 'Components'
        WebElement componentsHeading = driver.findElement(By.xpath("//h2[contains(text(), 'Components')]"));
        Assert.assertEquals(componentsHeading.getText(), "Components");
    }
}











































