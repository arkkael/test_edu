package cabus;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cabus.CheckAllDateForTheCAndC;
import cabus.OpenAllBookmarks;
import cabus.SearchExistContracts;

@RunWith(Suite.class)
@SuiteClasses({ //AutorizationSearch.class, 
	CheckAllDateForTheCAndC.class, 
	OpenAllBookmarks.class, 
	SearchExistContracts.class })
public class AllTests {

}