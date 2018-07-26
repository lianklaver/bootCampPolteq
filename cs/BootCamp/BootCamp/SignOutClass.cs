using System;
//using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCamp
{
    [TestFixture]
    public class SignOutClass
    {

        [Test]
        public void SignInAndSignOutCheck()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.Manage().Window.Maximize();

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

            driver.Close();
        }
    }

    [TestFixture]
    public class FillCartTest
    {

        [Test]
        public void EmptyAndFilledCartCheck()
        {
            //Open Chrome browser
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.Manage().Window.Maximize();

            IWebElement empty = driver.FindElement(By.ClassName("pajax_cart_no_product"));
            //Boolean visible = IsElementVisible(empty);

            driver.Close();
        }
    }
}
