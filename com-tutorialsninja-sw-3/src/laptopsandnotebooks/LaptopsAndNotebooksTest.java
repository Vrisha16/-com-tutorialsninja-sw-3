package laptopsandnotebooks;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/* 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 1.2 Click on “Show All Laptops & Notebooks”
             1.3 Select Sort By "Price (High > Low)"
             1.4 Verify the Product price will arrange in High to Low order.*/

    public class LaptopsAndNotebooksTest extends BaseTest {
        String baseUrl = ( "http://tutorialsninja.com/demo/index.php" );

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
            driver.get("http://tutorialsninja.com/demo/index.php?");
            // Mouse hover on "Laptops & Notebooks" Tab and click
            WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[contains(text(), 'Laptops & Notebooks')]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(laptopsAndNotebooksTab).perform();
            laptopsAndNotebooksTab.click();

            // Click on "Show All Laptops & Notebooks"
            WebElement showAllLaptopsAndNotebooksLink = driver.findElement(By.linkText("Show All Laptops & Notebooks"));
            showAllLaptopsAndNotebooksLink.click();

            // Select Sort By "Price (High > Low)"
            Select sortBySelect = new Select(driver.findElement(By.id("input-sort")));
            sortBySelect.selectByVisibleText("Price (High > Low)");
            // Get the list of product prices
            java.util.List<WebElement> productPrices = driver.findElements(By.cssSelector("div.price"));

            // Verify that the product prices are arranged in High to Low order
            double previousPrice = Double.MAX_VALUE;//find from google
            for (WebElement productPrice : productPrices) {
                String priceText = productPrice.getText().replace("Ex Tax: ", "").replace("$", "");
                double currentPrice = Double.parseDouble(priceText);
                Assert.assertTrue(currentPrice <= previousPrice);
                previousPrice = currentPrice;
            }

        }

        @Test
        public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
            driver.get("http://tutorialsninja.com/demo/index.php?");
            //2.1 Mouse hover on "Laptops & Notebooks" Tab and click
            WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[contains(text(), 'Laptops & Notebooks')]"));
            Actions actions1 = new Actions(driver);
            actions1.moveToElement(laptopsAndNotebooksTab).perform();
            laptopsAndNotebooksTab.click();

            //2.2Click on "Show All Laptops & Notebooks"
            WebElement showAllLaptopsAndNotebooksLink = driver.findElement(By.linkText("Show All Laptops & Notebooks"));
            showAllLaptopsAndNotebooksLink.click();


            //2.3 Select Sort By "Price (High > Low)"
            Select sortBySelect = new Select(driver.findElement(By.id("input-sort")));
            sortBySelect.selectByVisibleText("Price (High > Low)");
            java.util.List<WebElement> productPrices = driver.findElements(By.cssSelector("div.price"));
            //2.4 Select Product “MacBook”
            WebElement productLink = driver.findElement(By.linkText("MacBook"));
            productLink.click();
            //2.5 Verify the text “MacBook”
            WebElement productTitle = driver.findElement(By.cssSelector("h1.product-title"));
            Assert.assertEquals(productTitle.getText(), "MacBook");
            // 2.6 Click on ‘Add To Cart’ button
            WebElement productAdd = driver.findElement(By.linkText("MacBook"));
            productAdd.click();
            //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
            WebElement successMessage = driver.findElement(By.xpath("//div[@id='product-product']//div[@class='alert alert-success alert-dismissible']"));
            Assert.assertTrue(successMessage.getText().contains("Success: You have added MacBook to your shopping cart!"));
            //2.8 Click on link “shopping cart” display into success message
            WebElement shoppingCartLink = driver.findElement(By.xpath("//a[contains(text(), 'shopping cart')]"));
            shoppingCartLink.click();
            //2.9 Verify the text "Shopping Cart"
            WebElement shoppingCartTitle = driver.findElement(By.xpath("//div[@id='content']//h1"));
            Assert.assertEquals(shoppingCartTitle.getText(), "Shopping Cart");
            //2.10 Verify the Product name "MacBook"
            WebElement productName = driver.findElement(By.xpath("//table[@class='table table-bordered']//td[@class='text-left']//a[contains(text(), 'MacBook')]"));
            Assert.assertEquals(productName.getText(), "MacBook");
            //2.11 Change Quantity "2"
            WebElement quantityInput = driver.findElement(By.xpath("//input[@name='quantity[74dcdfa23a2c8b7f7b22e3b464f1e697]']"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            //2.12 Click on “Update” Tab
            WebElement updateButton = driver.findElement(By.xpath("//button[@name='update_cart']"));
            updateButton.click();
            //2.13 Verify the message “Success: You have modified your shopping cart!”
            WebElement updateSuccessMessage = driver.findElement(By.xpath("//div[@id='product-product']//div[@class='alert alert-success alert-dismissible']"));
            Assert.assertTrue(updateSuccessMessage.getText().contains("Success: You have modified your shopping cart!"));
            // 2.14 Verify the Total £737.45
            WebElement totalAmount = driver.findElement(By.xpath("//strong[text()='£737.45']"));
            Assert.assertEquals(totalAmount.getText(), "£737.45");
            //2.15 Click on “Checkout” button
            WebElement checkoutButton = driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]"));
            checkoutButton.click();
            //2.16 Verify the text “Checkout”
            WebElement CheckoutButton = driver.findElement(By.xpath(( "//h1[text()='Checkout']" )));
            Assert.assertEquals(checkoutButton.getText(), "Checkout");
            //2.17 Verify the Text “New Customer”
            WebElement newCustomerText = driver.findElement(By.xpath("//legend[text()='Step 1: Checkout Options']/following-sibling::p"));
            Assert.assertTrue(newCustomerText.getText().contains("New Customer"));
            //2.18 Click on “Guest Checkout” radio button
            WebElement guestCheckoutButton = driver.findElement(By.xpath("//input[@value='guest']"));
            guestCheckoutButton.click();
            //2.19 Click on “Continue” tab
            WebElement continueButton = driver.findElement(By.xpath("//input[@id='button-account']"));
            continueButton.click();
            //2.20 Fill the mandatory fields
            WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='input-payment-firstname']"));
            firstNameInput.sendKeys("Jay");
            WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='input-payment-lastname']"));
            lastNameInput.sendKeys("Latep");


            //2.21 Click on “Continue” Button
            WebElement continueButton1 = driver.findElement(By.xpath("//input[@id='button-payment-address']"));
            continueButton1.click();
            //2.22 Add Comments About your order into text area
            WebElement commentsTextarea = driver.findElement(By.xpath("//textarea[@name='comment']"));
            commentsTextarea.sendKeys("This is a test order");
            //2.23 Check the Terms & Conditions check box
            WebElement termsCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
            termsCheckbox.click();
            //2.24 Click on “Continue” button
            WebElement continueButton2 = driver.findElement(By.xpath("//input[@id='button-shipping-method']"));
            continueButton2.click();
            //2.25 Verify the message “Warning: Payment method required!”
            WebElement paymentWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')][contains(text(),'Warning: Payment method required!')]"));
            Assert.assertTrue(paymentWarningMessage.isDisplayed());

        }
    }






