package com.javatpoint.seleniumjavatpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchWindowsTest extends BaseTest{

    @Test(description="practiceSwitchWindow",
            enabled=true,
            groups = {"miscellaneous", "all"},
            dependsOnGroups={},
            dependsOnMethods={},
            priority=6
    )
    public void testPracticeSwitchWindow(){
        Assert.assertEquals(miscellaneous.practiceSwitchWindow(),2,"mismatch in number of windows");
    }

}
