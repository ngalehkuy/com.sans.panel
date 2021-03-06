package com.webview.ngalehkuy;

class SmartWebView {

	/* -- PERMISSION VARIABLES -- */
	static boolean ASWP_JSCRIPT       = true;         // enable JavaScript for webview
	static boolean ASWP_FUPLOAD       = true;         // upload file from webview
	static boolean ASWP_CAMUPLOAD     = true;         // enable upload from camera for photos
	static boolean ASWP_ONLYCAM       = false;        // incase you want only camera files to upload
	static boolean ASWP_MULFILE       = false;         // upload multiple files in webview
	static boolean ASWP_LOCATION      = false;         // track GPS locations
	static boolean ASWP_CP            = true;        // enable copy/paste within webview

	static boolean ASWP_RATINGS       = false;         // show ratings dialog; auto configured ; edit method get_rating() for customizations

	static boolean ASWP_PULLFRESH     = true;         // pull refresh current url
	static boolean ASWP_PBAR          = false;         // show progress bar in app
	static boolean ASWP_SLOAD          = true;         // loading in app while open page
	static boolean ASWP_ZOOM          = false;        // zoom control for webpages view
	static boolean ASWP_SFORM         = false;        // save form cache and auto-fill information
	static boolean ASWP_OFFLINE       = false;        // whether the loading webpages are offline or online
	static boolean ASWP_EXTURL        = true;         // open external url with default browser instead of app webview

	static boolean ASWP_TAB           = true;         // instead of default browser, open external URLs in chrome tab
	static boolean ASWP_ADMOB         = false;         // to load admob or not

	static boolean ASWP_EXITDIAL	  = true;         // confirm to exit app on back press

	static boolean ASWP_SLIDER      = true;

	/* -- SECURITY VARIABLES -- */
	static boolean ASWP_CERT_VERI     = true;         // verify whether HTTPS port needs certificate verification

	/* -- FCM SETTING -- */
	static String ASWV_FCM_CHANNEL = "NgalehKuy";

	/* -- CONFIG VARIABLES -- */
	// layout selection
	static int ASWV_LAYOUT            = 0;            // default=0; for clear fullscreen layout, and =1 for drawer layout

	// URL configs
	static String ASWV_URL            =  "https://pinki-pedia.com/auth/login"; //"https://spetr-media.com/auth/signin";  // https://spetr-media.com/auth/signin complete URL of your website or offline webpage "file:///android_asset/offline.html";
	static String ASWV_SEARCH         = "https://www.google.com/search?q=";         // search query will start by the end of the present string
	static String ASWV_SHARE_URL      = ASWV_URL + "?share=";                       // URL where you process external content shared with the app

	// domains allowed to be opened inside webview
	static String ASWV_EXC_LIST       = "accounts.google.com";       //separate domains with a comma (,)

	// custom user agent defaults
	static boolean POSTFIX_USER_AGENT       = true;         // set to true to append USER_AGENT_POSTFIX to user agent
	static boolean OVERRIDE_USER_AGENT      = true;        // set to true to use USER_AGENT instead of default one
	static String USER_AGENT_POSTFIX        = "NKuY_APP"; // useful for identifying traffic, e.g. in Google Analytics
	static String CUSTOM_USER_AGENT         = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36";    // custom user-agent

	// to upload any file type using "*/*"; check file type references for more
	static String ASWV_F_TYPE         = "*/*";

	// admob config
	static String ASWV_ADMOB          = "";		// your unique publishers ID

	/* -- RATING SYSTEM VARIABLES -- */
	static int ASWR_DAYS      = 3;            // after how many days of usage would you like to show the dialog
	static int ASWR_TIMES     = 10;           // overall request launch times being ignored
	static int ASWR_INTERVAL  = 2;            // reminding users to rate after days interval

}
