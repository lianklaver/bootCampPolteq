//using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCamp
{
    [TestFixture]
    public class LogInSuccesFullExtended
    {
        //public IWebDriver driver = new ChromeDriver();
        IWebDriver driver;

        [SetUp]
        public void Initialize()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");

            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys("lianne.klaver@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("Welkom01!");
            driver.FindElement(By.Id("SubmitLogin")).Click();
            //Console.WriteLine("SetUp is Run");
        }

        [Test]
        public void LogInPageHeaderCheck()
        {
            IWebElement pageHeader = driver.FindElement(By.ClassName("page-heading"));
            Assert.AreEqual(pageHeader.Text, "MY ACCOUNT");
        }

        [Test]
        public void LoginScreenCheck()
        {
            IWebElement pageHeader = driver.FindElement(By.ClassName("page-heading"));
            Assert.AreNotEqual(pageHeader.Text, "AUTHENTICATION");
        }

        [Test]
        public void LogInUserInfoCheck()
        {
            IWebElement headerUserInfo = driver.FindElement(By.CssSelector("div[class='header_user_info']>a"));
            Assert.AreEqual(headerUserInfo.Text, "Lianne Klaver");
        }

        [TearDown]
        public void CleanUp()
        {
            driver.Close();
        }
    }
}
