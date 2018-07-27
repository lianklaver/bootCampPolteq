using System;
using System.Threading;
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

            var wait = new WebDriverWait(driver, new TimeSpan(0, 0, 20));
            wait.Until(ExpectedConditions.ElementToBeClickable(driver.FindElement(By.CssSelector("span[title='Close window']")))).Click();

            Thread.Sleep(1000);
            driver.FindElement(By.CssSelector("[title='View my shopping cart']")).Click();

            wait.Until(ExpectedConditions.ElementToBeClickable(driver.FindElement(By.ClassName("icon-trash")))).Click();

            //Check if cart is empty
            wait.Until(ExpectedConditions.ElementIsVisible(By.CssSelector("span[class='ajax_cart_no_product']")));
            Assert.IsTrue(driver.FindElement(By.CssSelector("span[class='ajax_cart_no_product']")).Displayed);
        }
    }

    [TestFixture]
    public class AdjustPersonalInfoTest : TestShopScenario
    {
        [Test]
        public void ChangePersonalInformationCheck()
        {
            //check if logged in, if not, log in
            IWebElement headerUserInfo = driver.FindElement(By.CssSelector("div[class='header_user_info']>a"));

            if (!headerUserInfo.Text.Equals("Lianne Klaver"))
            {
                //Path to log in
                driver.FindElement(By.ClassName("login")).Click();
                driver.FindElement(By.Id("email")).SendKeys("lianne.klaver@polteq.com");
                driver.FindElement(By.Id("passwd")).SendKeys("Welkom01!");
                driver.FindElement(By.Id("SubmitLogin")).Click();
            }

            //click to personal information
            driver.FindElement(By.CssSelector("[title='Manage my personal information']")).Click();


            String naam2 = "Carla";
            String naam1 = "Lianne";

            IWebElement firstName = driver.FindElement(By.Id("firstname"));
            String newname;

            if (firstName.GetAttribute("value").Equals(naam1))
            {
                firstName.Clear();
                newname = naam2; 
            }
            else
            {
                firstName.Clear();
                newname = naam1; 
            }

            //enter new name in personal information
            firstName.SendKeys(newname);
            driver.FindElement(By.Id("old_passwd")).SendKeys("Welkom01!");
            driver.FindElement(By.Name("submitIdentity")).Click();

            //check if changed
            String check = newname + " Klaver";
            headerUserInfo = driver.FindElement(By.CssSelector("div[class='header_user_info']>a"));
            Assert.AreEqual(headerUserInfo.Text, check);
        }
    }

    [TestFixture]
    public class ValidateSupplierProductTest : TestShopScenario
    {
        [Test]
        public void MacbookAirCheck()
        {

            driver.FindElement(By.Name("supplier_list")).Click();

        }
    }




}
