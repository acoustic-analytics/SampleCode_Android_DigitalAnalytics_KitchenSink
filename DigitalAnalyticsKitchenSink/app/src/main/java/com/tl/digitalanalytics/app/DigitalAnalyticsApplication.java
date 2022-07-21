/***********************************************************************************************
 * Copyright (C) 2016 Acoustic, L.P. All rights reserved.
 *
 * NOTICE: This file contains material that is confidential and proprietary to
 * Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
 * industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
 * Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
 * prohibited.
 ***********************************************************************************************/
package com.tl.digitalanalytics.app;

import android.app.Application;

import com.da.DigitalAnalyticsModule;
import com.tl.uic.*;
import com.tl.uic.Tealeaf;

import com.digitalanalytics.api.DigitalAnalytics;

/**
 * @author Sohil Shah
 * 
 */
public class DigitalAnalyticsApplication extends Application {

    @Override
    public final void onCreate() {
        // Startup the Tealeaf module
        new Tealeaf(this);
        Tealeaf.enable();

        // Startup the Digital Analytics Module
        DigitalAnalytics.startup(this);

        super.onCreate();
    }

    @Override
    public final void onTerminate() {
        // Shutdown the Digital Analytics Module
        DigitalAnalytics.shutdown();

        //Disable the Tealeaf Module
        Tealeaf.disable();

        super.onTerminate();
    }

    @Override
    public void onLowMemory()
    {
        Tealeaf.onLowMemory();

        super.onLowMemory();
    }
}
