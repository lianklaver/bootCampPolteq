using System;
//using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace BootCamp
{
    [TestFixture]
    public class LogInSuccesfull
    {
        [Test]
        public void TestMethod1()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");

            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys("lianne.klaver@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("Welkom01!");
            driver.FindElement(By.Id("SubmitLogin")).Click();

            //Console.WriteLine("SetUp is Run");

            IWebElement pageHeader = driver.FindElement(By.ClassName("page-heading"));
            Assert.AreEqual(pageHeader.Text, "MY ACCOUNT");

            driver.Close();
        }
    }
}
