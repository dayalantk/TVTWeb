package TVT.TVT;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import java.io.File;


public class Api {
    
	 @SuppressWarnings("unchecked")
	@Test(priority=1)
	public void postProjectTVT()
	{   
		JSONObject requestParams = new JSONObject();
		requestParams.put("name","test2");
		requestParams.put("settings","Options1_global");
		 
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
			    .header("Accept","application/json")
				.header("Content-Type","application/json")
				.body(requestParams.toJSONString())
				.when()
				.post("/project/")
				.then()
				.statusCode(201)
				.extract().response();
		System.out.println(response.jsonPath().getString(""));
		Assert.assertEquals(201,response.getStatusCode());
		}
	
	 @Test(priority=2)
		public void getProjectTVT()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
				    .param("","")
					.when()
					.get("/project/")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("Compare-Julian",response.jsonPath().getString("name[0]"));
			Assert.assertEquals("Options1_global",response.jsonPath().getString("settings[0]"));
			Assert.assertEquals("new",response.jsonPath().getString("status[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("deviationCount[0]"));
			Assert.assertEquals("30",response.jsonPath().getString("deviationCount[1]"));
		}
		
	@Test(priority=3)
	public void getDocumentTVT()
	{   
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
			    .param("","")
				.when()
				.get("/document/1c913b30-68c3-4c8e-3ac1-08db7dd59ed2")
				.then()
				.statusCode(200)
				.extract().response();
		System.out.println(response.jsonPath().getString(""));
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
	public void postDocumentTVT()
	{   
		 	
		RestAssured.baseURI ="https://api.tvt-test.com/v1";
		Response response = RestAssured
				.given()
				.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
				.header("accept","application/json")
				.header("Content-Type","multipart/form-data")
				.multiPart("Document",new File("/home/dayalan/Documents/instagramscreenshot.docx"),"application/vnd.openxmlformats-officedocument.wordprocessingml.document")
				.when()
				.post("/document/")
				.then()
				.statusCode(200)
				.extract().response();
	System.out.println(response.getStatusCode());
	System.out.println(response.asString());
	}
	
	 @Test(priority=5)
		public void DocumentDownload()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("content-type","application/vnd.openxmlformats-officedocument.wordprocessingml.document ")
					.param("","")
					.when()
					.get("/document/a6a96ebb-f3c2-4d32-198c-08db7b8e952c/download")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.toString());
		}
	 
	 @Test(priority=6)
		public void getDocumentPageTVT()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/document/a6a96ebb-f3c2-4d32-198c-08db7b8e952c/page")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
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
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("Content-Type","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/compare")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
		   
		}
	 @Test(priority=7)
		public void deviationProject()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/deviations")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("2bed4c98-763b-4aab-1e16-08db7b8fa237",response.jsonPath().getString("deviationId[0]"));
			Assert.assertEquals("DEV1",response.jsonPath().getString("id[0]"));
			Assert.assertEquals("bb54296e-4c75-4f14-4fb8-08db7b8ecac5",response.jsonPath().getString("projectId[0]"));
			Assert.assertEquals("DLETYPE_DELETION",response.jsonPath().getString("deviationType[0]"));
			Assert.assertEquals("Deletion",response.jsonPath().getString("description[0]"));
			Assert.assertEquals("0001-01-01T00:00:00",response.jsonPath().getString("userActionDate[0]"));
			Assert.assertEquals("Created",response.jsonPath().getString("status[0]"));
		   
		}
	 @Test(priority=8)
		public void projectDocumentOrig()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/document?documentSide=Orig")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("a6a96ebb-f3c2-4d32-198c-08db7b8e952c",response.jsonPath().getString("documentId[0]"));
			Assert.assertEquals("Orig",response.jsonPath().getString("documentSide[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("documentOrder[0]"));
			
		}
	 @Test(priority=9)
		public void projectDocumentCopy()
		{   
			RestAssured.baseURI ="https://api.tvt-test.com/v1";
			Response response = RestAssured
					.given()
					.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkpzN1NnRWNZSUQ4b1hOaUt4X0QwVCJ9.eyJpc3MiOiJodHRwczovL3R2dC13ZWItdGVzdC5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHx0OHhYa2xfZWhBZ1hqdjVRRm5zeVFGMlY4MXU0TjdPUk1Jck1Xc2syX3FNIiwiYXVkIjoiaHR0cHM6Ly90dnQtc2VydmVyLnR2dC10ZXN0LmNvbSIsImlhdCI6MTY4ODcyNjcwMCwiZXhwIjoxNjg4ODEzMTAwLCJhenAiOiJqWjJ1OEdkS3NrbVlVb1dRWkd3dW5Id2hQMUhHZXVmRCIsInBlcm1pc3Npb25zIjpbIkRldmlhdGlvbjpDcmVhdGUiLCJEZXZpYXRpb246UmVhZCIsIlBhZ2U6UmVhZCIsIlByb2plY3Q6Q3JlYXRlIiwiUHJvamVjdDpEZWxldGUiLCJQcm9qZWN0RG9jdW1lbnQ6Q3JlYXRlIiwiUHJvamVjdERvY3VtZW50OkRlbGV0ZSIsIlByb2plY3REb2N1bWVudDpSZWFkIiwiUHJvamVjdDpFeGVjQ21kIiwiUHJvamVjdDpSZWFkIiwiUHJvamVjdDpVcGRhdGUiLCJTY3JlZW5zaG90OlJlYWQiLCJUVlRQcm9qZWN0OkNyZWF0ZSIsIlRWVFByb2plY3RGaWxlOlJlYWQiLCJUVlRQcm9qZWN0RmlsZTpVcGxvYWQiLCJUVlRQcm9qZWN0OlJlYWQiXX0.Zrct7dB14CZCGIFdhcOikCCCOFpYUx5D5rkd45yrO6eGY-q4xwjvOKSIByBTKbppWApSCRn77RtkPJcotdnap73OrAxtHO4WNRGBruE2ntflgsUrZWtvspqXgebQe07ecMDAO8p6PYKwir_NMtMyv6HTRThK-M0cMZCcW6IJ4LxYv5az0mbIOfJLFysv3iUMtxa3IZFrALCYiIiATA3xqpeoETAucp0Zu71uzPqnZJ8Pxii7wkPdvAULTkvjpOfsF7Fgw7dAuVYh5L6CxsA95u9_5SxtusPr29ZUeK_67zJlHV3AZxRV6IGsSSnrM-yStexgeMseuCAwhU2Y6O8t6A")
					.header("accept","application/json")
					.param("","")
					.when()
					.get("/project/bb54296e-4c75-4f14-4fb8-08db7b8ecac5/document?documentSide=Copy")
					.then()
					.statusCode(200)
					.extract().response();
			System.out.println(response.jsonPath().getString(""));
			Assert.assertEquals(200,response.getStatusCode());
			Assert.assertEquals("ddc471e2-8d58-421a-198d-08db7b8e952c",response.jsonPath().getString("documentId[0]"));
			Assert.assertEquals("Copy",response.jsonPath().getString("documentSide[0]"));
			Assert.assertEquals("0",response.jsonPath().getString("documentOrder[0]"));
		}
	
	 
}


