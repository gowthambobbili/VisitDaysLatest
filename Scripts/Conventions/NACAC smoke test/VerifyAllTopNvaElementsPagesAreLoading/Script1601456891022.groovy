import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginToNacacStudentAppAsStudentInNewBrowser'()

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/UpcomingOptionInHomePage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("upcoming option header is not present in events home page")
}
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VideosButtonInTopNav'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ExploreVideosHeaderInVideosPage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Explore videos header is not present in videos page")
}
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FavoritesInTopNav'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FavoriteHeaderInFavoritesPage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("favorites header is not present in videos page")
}

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinearariesTopNav'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsOrMeetingSwitcherNavInItinenariespage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("itinenaries page is not loaded")
}

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/MyMeetingsOptionInItinenariesPage'))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AccountBasicsInTopNav'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AccountBasicsHeaderInAccountBasicspage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Account basics page is not loaded")
}
WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonalInfoTabInAccountbasicspage'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/NotificationstabInPersonalDeatailsPage'))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/preferencesHeaderInNotificationsPage'), 0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Notifications Page is not loaded")
}







