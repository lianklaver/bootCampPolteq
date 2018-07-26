using System;
//using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace BootCamp
{
    [TestFixture]
    public class TestShopScenario
    {
        protected IWebDriver driver;

        [SetUp]
        public void Initialize()
        {
            //Open Chrome browser
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.Manage().Window.Maximize();
        }

        [TearDown]
        public void tearDown()
        {
            driver.Quit();
        }
    }

    [TestFixture]
    public class SignOutClass : TestShopScenario
    {
        
        [Test]
        public void SignInAndSignOutCheck()
        {
            //IWebDriver driver = new ChromeDriver();
            //driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            //driver.Manage().Window.Maximize();

            //Path to log in
            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys("lianne.klaver@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("Welkom01!");
            driver.FindElement(By.Id("SubmitLogin")).Click();

            //Assertion if logged in
            IWebElement pageHeader = driver.FindElement(By.ClassName("page-heading"));
            Assert.AreEqual(pageHeader.Text, "MY ACCOUNT");

            //Path to log out 
            driver.FindElement(By.ClassName("logout")).Click();


            //Assertion if logged out
            pageHeader = driver.FindElement(By.ClassName("page-heading"));
            Assert.AreEqual(pageHeader.Text, "AUTHENTICATION");

            //driver.Close();
        }
    }

    [TestFixture]
    public class FillCartTest : TestShopScenario
    {

        [Test]
        public void EmptyAndFilledCartCheck()
        {
            //Open Chrome browser
            //IWebDriver driver = new ChromeDriver();
            //driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            //driver.Manage().Window.Maximize();

            //Check if cart is empty
            Assert.IsTrue(driver.FindElement(By.CssSelector("span[class='ajax_cart_no_product']")).Displayed);

            //Add Ipod Shuffel to chart
            driver.FindElement(By.CssSelector("a[class='tag_level3 first_item']")).Click();
            driver.FindElement(By.XPath("//a[contains(@class,'product-name')][contains(text(),'iPod shuffle')]")).Click();
            driver.FindElement(By.CssSelector("button[class='exclusive']")).Click();

            IWebElement closeButton = driver.FindElement(By.CssSelector("span[title='Close window']"));
            var wait = new WebDriverWait(driver, new TimeSpan(0, 0, 2));
            wait.Until(ExpectedConditions.ElementToBeClickable(closeButton));
            closeButton.Click();

            //check 1 product in chart
            Assert.AreEqual(driver.FindElement(By.CssSelector("span[class='ajax_cart_quantity unvisible']")).Text, "1");
            //Assert.Greater(driver.FindElement(By.CssSelector("span[class='ajax_cart_quantity unvisible']")).GetAttribute("inline")),0, "Nothing in the chart"));

            //driver.Close();
        }
    }

    [TestFixture]
    public class EmptyCartTest : TestShopScenario
    {
        [Test]
        public void EmptyCartCheck()
        {

            //Open Chrome browser
            //IWebDriver driver = new ChromeDriver();
            //driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            //driver.Manage().Window.Maximize();

            //Check if cart is empty
            Assert.IsTrue(driver.FindElement(By.CssSelector("span[class='ajax_cart_no_product']")).Displayed);

            //Add Ipod Shuffel to chart
            driver.FindElement(By.CssSelector("a[class='tag_level3 first_item']")).Click();
            driver.FindElement(By.XPath("//a[contains(@class,'product-name')][contains(text(),'iPod shuffle')]")).Click();
            driver.FindElement(By.CssSelector("button[class='exclusive']")).Click();

            IWebElement closeButton = driver.FindElement(By.CssSelector("span[title='Close window']"));
            var wait = new WebDriverWait(driver, new TimeSpan(0, 0, 2));
            wait.Until(ExpectedConditions.ElementToBeClickable(closeButton));
            closeButton.Click();

            driver.FindElement(By.CssSelector("div[class='shopping_cart']")).Click();

            //driver.FindElement(By.CssSelector("div[class='layer_cart_product col-xs-12 col-md-6']>a")).Click();
            driver.FindElement(By.ClassName("icon-trash")).Click();

            //Check if cart is empty
            Assert.IsTrue(driver.FindElement(By.CssSelector("span[class='ajax_cart_no_product']")).Displayed);

        }
    }

}
