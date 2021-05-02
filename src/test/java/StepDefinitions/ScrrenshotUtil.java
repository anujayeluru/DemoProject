package StepDefinitions;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
public class ScrrenshotUtil {

	//static int counter=0;
	static ArrayList<String> ArrayImgs=new ArrayList<String>();
	public static void capture(WebDriver driver,String path) throws IOException

	{
		System.out.println("Driver is in "+driver.getTitle());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
		//counter=counter++;
		//System.out.println("Counter="+counter);
		System.out.println("Screenshot taken");
	}

	public static void ToArray(String img)
	{
		ArrayImgs.add(img);
	}

	public static void createWord(String filename) throws InvalidFormatException, FileNotFoundException, IOException 
	{
		int size=ArrayImgs.size();
		XWPFDocument doc=new XWPFDocument();
		XWPFParagraph para=doc.createParagraph();
		XWPFRun run=para.createRun();
		run.setText("Automation for TC Screenshot");
		
		for (int i=0;i<size;i++)
		{
			para=doc.createParagraph();
			run=para.createRun();
			String imgPath=ArrayImgs.get(i);
			run.addPicture(new FileInputStream(imgPath),XWPFDocument.PICTURE_TYPE_PNG,imgPath, Units.toEMU(400),Units.toEMU(200));
			
		}

		
doc.write(new FileOutputStream("E:/Eclipse2020/Workspace/CucumberJava/"+filename+".docx"));
	}

}
