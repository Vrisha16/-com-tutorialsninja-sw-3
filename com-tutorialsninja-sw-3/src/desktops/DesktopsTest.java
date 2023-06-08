package desktops;

import graphql.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Mouse hover on Desktops Tab.and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.*/
public class DesktopsTest extends BaseTest {
    String url = ( "http://tutorialsninja.com/demo/index.php" );

    @Before
    public void setUp() {
        String baseurl;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        WebElement dropDown = driver.findElement(By.name("Desktops"));
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        int sizeOfAllOptions = allOptions.size();
        System.out.println(sizeOfAllOptions);
        for (WebElement nameOfProduct : allOptions) {
            if (nameOfProduct.getText().equalsIgnoreCase("Show All Desktops")) {
                System.out.println(nameOfProduct.getText());
                for (WebElement SortByposition : allOptions) {
                    if (SortByposition.getText().equalsIgnoreCase("Name: Z to A")) {
                        System.out.println(SortByposition.getText());
                        String actualTitle = driver.getTitle(); // getting title of page
                        System.out.println("Verify the Product will arrange in Descending order." + actualTitle); //printing title of page
                        String expectedTitle = null;//by inbuilt need to ask bhaveshbhai or in group study to all test
                        Assert.assertTrue(expectedTitle.equals(actualTitle));
                    }
                    @Test
                    public void verifyProductAddedToShoppingCartSuccessFully ( ) {
                        //Base url
                        driver.get("http://tutorialsninja.com/demo/index.php");
//2.1 Mouse hover on Desktops Tab. and click
                        WebElement desktopsTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
                        Actions actions = new Actions(driver);
                        actions.moveToElement(desktopsTab).perform();
                        desktopsTab.click();
                        //2.2 Click on “Show All Desktops”
                        WebElement showAllDesktopsButton = driver.findElement(By.xpath("//a[text()='Show All Desktops']"));
                        showAllDesktopsButton.click();
                        //2.3 Select Sort By position "Name: A to Z"
                        WebElement sortByDropdown = driver.findElement(By.id("input-sort"));
                        Select sortBySelect = new Select(sortByDropdown);
                        sortBySelect.selectByVisibleText("Name: A to Z");
                        //2.4 Select product “HP LP3065”
                        WebElement productLink = driver.findElement(By.xpath("//a[text()='HP LP3065']"));
                        productLink.click();
                        //2.5 Verify the Text "HP LP3065"
                        WebElement productName = driver.findElement(By.xpath("//h1[text()='HP LP3065']"));
                        Assert.assertEquals(  productName.getText(), "HP LP3065");

                        //2.6 Select Delivery Date "2022-11-30"
                        WebElement deliveryDateField = driver.findElement(By.id("input-option225"));
                        deliveryDateField.sendKeys("2022-11-30");

                        //2.7.Enter Qty "1” using Select class.
                        WebElement qtySelectElement = driver.findElement(By.id("input-quantity"));
                        Select qtySelect = new Select(qtySelectElement);
                        qtySelect.selectByVisibleText("1");
                        //2.8 Click on “Add to Cart” button
                        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
                        addToCartButton.click();
                        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
                        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
                        Assert.assertTrue(successMessage.getText().contains("Success: You have added HP LP3065 to your shopping cart!"));
                        //2.10 Click on link “shopping cart” display into success message
                        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[text()='shopping cart']"));
                        shoppingCartLink.click();
                        //2.11 Verify the text "Shopping Cart"
                        WebElement shoppingCartText = driver.findElement(By.xpath("//h1[text()='Shopping Cart']"));
                        Assert.assertEquals(shoppingCartText.getText(), "Shopping Cart");
                        //2.12 Verify the Product name "HP LP3065"
                        WebElement productNameInCart = driver.findElement(By.xpath("//td[@class='text-left'][contains(text(),'HP LP3065')]"));
                        Assert.assertEquals(productNameInCart.getText(), "HP LP3065");
                        //2.13 Verify the Delivery Date "2022-11-30"
                        WebElement deliveryDateInCart = driver.findElement(By.xpath("//td[@class='text-left'][contains(text(),'2022-11-30')]"));
                        Assert.assertEquals(deliveryDateInCart.getText(), "2022-11-30");
                        //2.14 Verify the Model "Product21"
                        WebElement modelInCart = driver.findElement(By.xpath("//td[@class='text-left'][contains(text(),'Product21')]"));
                        Assert.assertEquals(modelInCart.getText(), "Product21");
                        //2.15 Verify the Todat "£74.73"
                        WebElement totalInCart = driver.findElement(By.xpath("//td[contains(text(),'£74.73')]"));
                        Assert.assertEquals(totalInCart.getText(), "£74.73");
                    }
                }
            }
        }
    }
}














































