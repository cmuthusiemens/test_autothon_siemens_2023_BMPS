package mobile.framework;

import mobile.pages.*;
import mobile.utils.ConfigFileReader;

public class PageFactory {
	protected HomePage HomePage = new HomePage();
	protected StepInForumPage StepInForumPage = new StepInForumPage();
	protected static ConfigFileReader ConfigFileReader = new ConfigFileReader();
}
