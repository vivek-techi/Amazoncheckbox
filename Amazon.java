import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class Amazon {

    public static WebDriver driver = null;
    public static String url = "https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb";


    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static  List <String>  actualStoreDepartmentsList() {
        List<String> rData = null;
        try {
            rData = new ArrayList<String>();
            List<WebElement> departmentsList = driver.findElements(By.xpath("//div[contains(text(),'Departments')]/..//span"));
            for (WebElement dep : departmentsList) {
            rData.add(dep.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rData;
    }


    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        amazon.openBrowser();
        amazon.assertDepartments(expectedStoreDepartmentsList(),actualStoreDepartmentsList());
        amazon.tearDown();
    }

    public void assertDepartments(ArrayList<String> expectedStoreDepartmentsList, List<String> actualStoreDepartmentsList) {
         for(String exp : expectedStoreDepartmentsList){
             if(actualStoreDepartmentsList.contains(exp)){
                 System.out.println(exp + "  is present in Departments");
             }else{
                 System.out.println(exp + "  is not present in Departments");
             }
         }
    }


    public static ArrayList<String> expectedStoreDepartmentsList() {
        ArrayList<String> departmentList = new ArrayList<String>();
        departmentList.add("Amazon Devices");
        departmentList.add("Arts, Crafts & Sewing");
        departmentList.add("Automotive & Motorcycle");
        departmentList.add("Baby");
        departmentList.add("Baby Clothing & Accessories");
        departmentList.add("Beauty");
        departmentList.add("Books");
        departmentList.add("Boys’ Fashion");
        departmentList.add("Camera & Photo");
        departmentList.add("Cell Phones & Accessories");
        departmentList.add("Computers & Accessories");
        departmentList.add("Costumes & Accessories");
        departmentList.add("Electronics");
        departmentList.add("Everything Else");
        departmentList.add("Fashion");
        departmentList.add("Furniture");
        departmentList.add("Gift Cards");
        departmentList.add("Girls’ Fashion");
        departmentList.add("Grocery");
        departmentList.add("Headphones");
        departmentList.add("Health & Personal Care");
        departmentList.add("Home");
        departmentList.add("Home Audio");
        departmentList.add("Home Improvement");
        departmentList.add("Industrial & Scientific");
        departmentList.add("Kindle");
        departmentList.add("Kindle eBooks");
        departmentList.add("Kitchen");
        departmentList.add("Luggage Travel Gear");
        departmentList.add("Magazines");
        departmentList.add("Major Appliances");
        departmentList.add("Men's Shoes");
        departmentList.add("Men's Watches");
        departmentList.add("Men’s Clothing");
        departmentList.add("Men’s Fashion");
        departmentList.add("Movies & TV");
        departmentList.add("Music");
        departmentList.add("Musical Instruments");
        departmentList.add("Office Electronics & Supplies");
        departmentList.add("Patio, Lawn & Garden");
        departmentList.add("Pet Supplies");
        departmentList.add("Power & Hand Tools");
        departmentList.add("Software");
        departmentList.add("Sports & Outdoors");
        departmentList.add("Television & Video");
        departmentList.add("Toys & Games");
        departmentList.add("Video Games");
        departmentList.add("Women's Shoes");
        departmentList.add("Women's Watches");
        departmentList.add("Women’s Clothing");
        departmentList.add("Women’s Fashion");
        departmentList.add("Women’s Jewelry");
        departmentList.add("match box");
        departmentList.add("check box");

        return departmentList;
    }


}


