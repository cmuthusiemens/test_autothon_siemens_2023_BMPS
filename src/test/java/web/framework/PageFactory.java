package web.framework;

import web.pages.*;
import web.utils.ConfigFileReader;

public class PageFactory {
	protected HomePage HomePage = new HomePage();
	protected X_Page X_Page = new X_Page();
	protected static ConfigFileReader ConfigFileReader = new ConfigFileReader();
}
