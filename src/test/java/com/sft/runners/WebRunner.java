package com.sft.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/sft/steps","com/sft/hooks"},
        //tags = "@Smoke or @Regression and @Bug"
        tags = "@Smoke"
)
public class WebRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @BeforeClass
    public void beforeClass(ITestContext iTestContext){
        iTestContext.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
    }
}
