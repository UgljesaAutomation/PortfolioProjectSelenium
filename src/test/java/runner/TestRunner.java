package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/LoginPage.feature"},
        glue = {"stepdefs"},
        plugin = {
                "pretty",
                "html:E:/Programiranje/IdeaProjects/Test_Result/",  // ← Tvoja konkretna lokacija
                //"json:C:/TestReports/CucumberReport/report.json"
        }
        //tags = "@TopAnime"
)
public class TestRunner {
}