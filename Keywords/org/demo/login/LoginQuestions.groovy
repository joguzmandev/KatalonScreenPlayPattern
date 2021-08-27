package org.demo.login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertTrue

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class LoginQuestions {

	def isLoginSuccess() {
		//TODO try to valid and invalid user using the saame test case
		
		String actualdResult = null
		try {
			
			//==========================VALID USER NAME====================================
			
			//# Start Code Valid
			WebUI.waitForPageLoad(GlobalVariable.timeOut)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Dashboard/user_menu_top_anchor'), GlobalVariable.timeOut)
			actualdResult = WebUI.getText(findTestObject('Object Repository/Page_Dashboard/user_menu_top_anchor'), FailureHandling.STOP_ON_FAILURE)
			assertTrue(actualdResult.contains("Welcome"))

			
			//==========================INVALID USER NAME====================================
			
			//Invalid user
			WebUI.waitForPageLoad(GlobalVariable.timeOut)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Login/errorMessage_span'), GlobalVariable.timeOut)
			actualdResult = WebUI.getText(findTestObject('Object Repository/Page_Login/errorMessage_span'), FailureHandling.STOP_ON_FAILURE)
			assertTrue(actualdResult.contains("Invalid credentials"))

			
		}catch(WebElementNotFoundException notFound) {}
	}
}
