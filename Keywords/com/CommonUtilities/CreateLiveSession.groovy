package com.CommonUtilities
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.text.*;
import java.lang.String
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date


public class CreateLiveSession {
	Random rd=new Random()
	Random rd2=new Random()
	Date dNow = new Date()
	Date tomorow = new Date(dNow.getTime() + (1000 * 60 * 60 * 24))
	SimpleDateFormat ft =new SimpleDateFormat ("MM/dd/yyyy")
	String meetdates=(ft.format(dNow)).toString()
	def meetdate=meetdates.substring(0,5)
	def tomorowdate=(ft.format(tomorow)).toString()
	SimpleDateFormat time=new SimpleDateFormat("h:mm a");
	String time1=(time.format(dNow)).toString()
	def num=rd.nextInt(100000)
	def sessionname="TestSession"+num
	def ZoomId="https://zoom.us/j/12345678"
	@Keyword
	def selectConvention() {
		WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

		WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

		WebUI.waitForPageLoad(5)

//		def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))
//
		WebUI.click(findTestObject('ConventionsPageAdmin/SelectFirstConvention',['ConventionName':GlobalVariable.createdConventionName]))
		
		return GlobalVariable.createdConventionName

//		return ConventionName
	}
	@Keyword
	def enterLiveSessionDetailsAndTime() {

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		println(meetdate)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),meetdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"12")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),'a')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),meetdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"11")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"45")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"p")

		return sessionname
	}
	@Keyword
	def enterLiveSessionDetailsAndFutureTime() {
		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/Name field'),sessionname)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/Descriptionfield'),"this is test description")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/dateFieldAtStartTime'),tomorowdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"12")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),"00")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtStartTime'),'a')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/DateFieldAtEndTime'),tomorowdate)

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"11")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"45")

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/TimeFieldAtEndTime'),"p")

		return sessionname
	}

	@Keyword
	def enterZoomIdAndAddAssigne() {

		WebUI.setText(findTestObject('Object Repository/ConventionsPageAdmin/ZoomMeetingField'),ZoomId)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionsPageAdmin/CapacityField'),"5")

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/AssigneesDropDown'))

		WebUI.delay(5)

		def AssigneesCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionsPageAdmin/SelectAssigneByDropDownSessions'),0).size()

		def AssigneeNo =rd2.nextInt(AssigneesCount)

		def assigneeName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions', ['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/selectDropSessions',['Index':AssigneeNo]))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Add button of add assigne'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/upload photo'))

		String userDir = System.getProperty('user.dir')

		WebUI.uploadFile(findTestObject('Object Repository/ConventionsPageAdmin/BrowsePhotoAddress'),userDir + '\\studentimg.jpg')

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ApplybuttoninPhotoUpload'))

		WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'))

		//		WebUI.waitForElementNotPresent(findTestObject('Object Repository/ConventionsPageAdmin/SaveButton'), 0)

		WebUI.delay(5)

		return ZoomId
	}
}