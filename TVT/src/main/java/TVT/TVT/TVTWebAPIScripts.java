package TVT.Web;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.io.File;


public class TVTWebAPIScripts {
    @BeforeSuite()
    public void token()
    {
    	String TOKEN_VALUE = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4OTY2Nzc3OSwiZXhwIjoxNjg5NzU0MTc5LCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.HWJtYN2vAxWMV1oAcMA6uAw9jkC0ZTBuf-CiUWV88tovEHPmkJDw9uSUZSSkHNKBF420ox0nV6rVnsaZPZqtP9bHblrWqbvwsdeVXk7l6sHSSzuIVgWZ9N1sH9SNT9O2SO-vJgbp_6tOwutbdFO1EUBMwVBc4U13VwJpVbnUoPwFmiqZ1aUm0rRXb7iGkoSLxcbAnDlR4K2aTGTKY0cKAPckNMC6oaln3I-5qBRZmSVE2gvDXxiMVjTe-G8PoT_Gquwci8mNNyqaHFMX6HKNnBUNXk6StrW7MbthFMKDpZNTTIE7Z6-l1nC3trleqVuEynWkmWANN47IRUOX4on31g";
    	System.setProperty("token", TOKEN_VALUE);
    }
	 @SuppressWarnings("unchecked")
	@Test(priority=1)
	public void CreateProjectTVT()
	{   
		JSONObject requestParams = new JSONObject();
		requestParams.put("name","test2");
		requestParams.put("settings","Options1_global");
		 
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
			    .header("Accept","application/json")
				.header("Content-Type","application/json")
				.body(requestParams.toJSONString())
				.when()
				.post("/project/")
				.then()
				.statusCode(201)
				.extract().response();
		System.out.println("New Project is created and Project ID is :"+response.jsonPath().getString(""));
		Assert.assertEquals(201,response.getStatusCode());
		}
	
	 @Test(priority=2)
		public void AvailableProjectDetailsinTVT()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
				    .param("","")
					.when()
					.get("/project/")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Available Projects are :" +response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("Compare-Julian",response.jsonPath().getString("name[0]"));
			Assert.assertEquals("Options1_global",response.jsonPath().getString("settings[0]"));
			Assert.assertEquals("new",response.jsonPath().getString("status[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("deviationCount[0]"));
			Assert.assertEquals("30",response.jsonPath().getString("deviationCount[1]"));
		}
		
	@Test(priority=3)
	public void availableDocumentDetailsinTVT()
	{   
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
			    .param("","")
				.when()
				.get("/document/1c913b30-68c3-4c8e-3ac1-08db7dd59ed2")
				.then()
				.statusCode(200)
				.extract().response();
		System.out.println("Available Documents are :"+response.jsonPath().getString(""));
		Assert.assertEquals(200,response.getStatusCode());
		Assert.assertEquals("instagramscreenshot.docx",response.jsonPath().getString("fileName"));
		Assert.assertEquals("5560",response.jsonPath().getString("fileSize"));
		Assert.assertEquals("1",response.jsonPath().getString("pageCount"));
		Assert.assertEquals("359",response.jsonPath().getString("wordCount[0]"));
		Assert.assertEquals("0",response.jsonPath().getString("imageCount[0]"));
		Assert.assertEquals("0",response.jsonPath().getString("pageWidths[0]"));
		Assert.assertEquals("0",response.jsonPath().getString("pageHeights[0]"));
		Assert.assertEquals("Rendered",response.jsonPath().getString("status"));
	   
	}
	@Test(priority=4)
	public void createDocumentTVTDocx()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Documents/instagramscreenshot.docx"),"application/vnd.openxmlformats-officedocument.wordprocessingml.document")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New Docx Document is created and ID is :"+response.asString());
	}
	@Test(priority=5)
	public void createDocumentTVTDoc()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/testing 6.doc"),"application/msword")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New Doc Document is created and ID is :"+response.asString());
	}
	@Test(priority=6)
	public void createDocumentTVTpdf()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/dummy.pdf"),"application/pdf")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New PDF Document is created and ID is :"+response.asString());
	}		
	
	@Test(priority=7)
	public void createDocumentTVTEPS()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/images/sample.eps"),"image/x-eps")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New EPS Document is created and ID is :"+response.asString());
	}		
	
	@Test(priority=8)
	public void createDocumentTVTAI()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/images/sample.ai"),"application/illustrator")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New AI Document is created and ID is :"+response.asString());
	}		
	@Test(priority=9)
	public void createDocumentTVTJPG()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/images/sample.jpg"),"image/jpeg")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New JPG Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=10)
	public void createDocumentTVTPPT()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/images/sample.ppt"),"application/vnd.ms-powerpoint")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New PPT Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=11)
	public void createDocumentTVTPPTX()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/PPT/sample.pptx"),"application/vnd.openxmlformats-officedocument.presentationml.presentation")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New PPTX Document is created and ID is :"+response.asString());
	}	

	@Test(priority=12)
	public void createDocumentTVTDOCM()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/PPT/sample.docm"),"application/vnd.ms-word.document.macroEnabled.12")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New DOCM Document is created and ID is :"+response.asString());
	}	

	@Test(priority=13)
	public void createDocumentTVTTXT()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.txt"),"text/plain")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New TXT Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=14)
	public void createDocumentTVTEXCEL()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.xls"),"application/vnd.ms-excel")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New Excel Document is created and ID is :"+response.asString());
	}	
	
	
	
	
	
	@Test(priority=15)
	public void createDocumentTVTRTF()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.rtf"),"application/rtf")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New RTF Document is created and ID is :"+response.asString());
	}	
	@Test(priority=16)
	public void postDocumentTVTBIGEXCEL()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/samplebig.xls"),"application/vnd.ms-excel")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New BIGExcel Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=17)
	public void createDocumentTVTXLSX()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.xlsx"),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")	
				//type=application/vnd.openxmlformats-officedocument.spreadsheetml.sheet /home/dayalan/Downloads/sample.xlsx
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New XLSX Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=18)
	public void createDocumentTVTXLSM()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.xlsm"),"application/vnd.ms-excel.sheet.macroEnabled.12")	
				//type=application/vnd.openxmlformats-officedocument.spreadsheetml.sheet /home/dayalan/Downloads/sample.xlsx
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New XLSM Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=19)
	public void createDocumentTVTXML()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.xml"),"text/xml")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New XML Document is created and ID is :"+response.asString());
	}	
	
	@Test(priority=20)
	public void createDocumentTVTXSD()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.xsd"),"text/xml")	
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New XSD Document is created and ID is :"+response.asString());
	}	

	@Test(priority=21)
	public void createDocumentTVTHTML()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Downloads/sample.html"),"text/xml")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New HTML Document is created and ID is :"+response.asString());
	}	

	@Test(priority=22)
	public void createDocumentTVTZIP()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization",System.getProperty("token"))
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Desktop/PPT.zip"),"application/zip")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println("New ZIP Document is created and ID is :"+response.asString());
	}	
	
				@Test(priority=23)
		public void DocumentDownload()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
					.header("content-type","application/vnd.openxmlformats-officedocument.wordprocessingml.document ")
					.param("","")
					.when()
					.get("/document/a6a96ebb-f3c2-4d32-198c-08db7b8e952c/download")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Document Download Details :"+response.toString());
		}
				
	 @Test(priority=24)
		public void DocumentPageTVTDetails()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/document/a6a96ebb-f3c2-4d32-198c-08db7b8e952c/page")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Created Document pages are :"+response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("0",response.jsonPath().getString("pageNumber[0]"));
			Assert.assertEquals("359",response.jsonPath().getString("wordCount[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("imageCount[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("barCodeCount[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("pageWidth[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("pageHeight[0]"));
		   
		}
	 @Test(enabled=false)
		public void compareProject()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("accept","*/*")
					.header("Authorization",System.getProperty("token"))
					.header("Content-Type","application/json")
					.param("","")
					.when()
					.post("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/compare")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
		   
		}
	 @Test(priority=25)
		public void deviationProjectDetails()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/deviations")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Project Deviations are :"+response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("2bed4c98-763b-4aab-1e16-08db7b8fa237",response.jsonPath().getString("deviationId[0]"));
			Assert.assertEquals("DEV1",response.jsonPath().getString("id[0]"));
			Assert.assertEquals("DLETYPE_DELETION",response.jsonPath().getString("deviationType[0]"));
			Assert.assertEquals("Deletion",response.jsonPath().getString("description[0]"));
			Assert.assertEquals("0001-01-01T00:00:00",response.jsonPath().getString("userActionDate[0]"));
			Assert.assertEquals("Created",response.jsonPath().getString("status[0]"));
		   
		}
	 @Test(priority=26)
		public void projectDocumentOrigDetail()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/document?documentSide=Orig")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Project Document Original:"+response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("a6a96ebb-f3c2-4d32-198c-08db7b8e952c",response.jsonPath().getString("documentId[0]"));
			Assert.assertEquals("Orig",response.jsonPath().getString("documentSide[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("documentOrder[0]"));
			
		}
	 @Test(priority=27)
		public void projectDocumentCopyDetail()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization",System.getProperty("token"))
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/document?documentSide=Copy")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println("Project Document Copy:"+response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("ddc471e2-8d58-421a-198d-08db7b8e952c",response.jsonPath().getString("documentId[0]"));
			Assert.assertEquals("Copy",response.jsonPath().getString("documentSide[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("documentOrder[0]"));
		}
	
	 
}
