package com.Test;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;

public class MonkeyGalenTestExtended extends MonkeyGalenTest {

	    public final static String NAV_FORM_BTN = "(//*[contains(@class,'bs-docs-sidenav')]/li/a)[6]";

	    public final static String INPUT_EMAIL = "//*[contains(@data-example-id,'basic-forms')]//input[contains(@type,'email')]";

	    /**
	     * @param pTestDevice
	     */
	    public MonkeyGalenTestExtended(TestDevice pTestDevice) {
	        super(pTestDevice);
	    }

	    protected String getDefaultURL() {
	        return "http://www.corriere.it";
	    }

	    @Test
	    public void shouldShowCorrectBaseLayout() throws Exception {
	        load("/");
	        //enterText(By.id("lst-ib"), "Galen Testing");
	        //clickElement(By.xpath("//*[contains(@class,'lsb')]//button"));
	        verifyPage("/specs/googlePageLayout.gspec", Arrays.asList("Corriere"));
	    }

	}

