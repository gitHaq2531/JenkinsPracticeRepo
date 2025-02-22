package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.client.vtiger.objectRepository.CreateNewOrganizationPage;
import com.client.vtiger.objectRepository.HomePage;
import com.client.vtiger.objectRepository.OrganizationInfoPage;
import com.client.vtiger.objectRepository.OrganizationsPage;
import com.clientName.vtiger.generic.excelUtility.ExcelUtility;
import com.vtiger.generic.baseUtility.BaseClass;

public class DeleteOrgTest extends BaseClass
{
	@Test
	public void deleteOrg() throws IOException {

		//READ DATA from excel file
		ExcelUtility excelutil=new ExcelUtility();
		String email = excelutil.getDataFromExcel("./testData/ProjectTestCaseData.xlsx","vtigerTestData",1,2)+ju.getRandomValue();
		
		//2. navigate to organization page....
		HomePage hp=new HomePage(driver);
		hp.getOrganizationLink().click();
		
		//3. navigate to create new organition page....
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();
		
		//4. create new organization with org name....
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrgWithOrgName(email);

		//5. verify header message with expected result....
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String headName = oip.getHeadName().getText();
		if(headName.contains(email))
		{
			System.out.println(email+" name is verified : passed");
		}else {
			System.out.println(email+" name is not verified: failed");
		}
		
		//6. delete org from org page....
		hp.getOrganizationLink().click();
		op.deleteOrg(wdu, email);
	}
}
