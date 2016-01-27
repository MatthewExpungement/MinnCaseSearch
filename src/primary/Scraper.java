package primary;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {
	
	public String getHTML(String casenumber){
		//Attempt to get the cases from the caseno in the url. It seems as if you can only view the cases through this method that are returned in your search.
		String html = "Error";
		String url = "http://pa.courts.state.mn.us/CaseDetail.aspx?CaseID=" + casenumber;
		String pubacccookie = "8FA86ADDED7C59B490E53E9310C9964A552DB1E175403019D512AF721D74126B4D4DBA1657F230C67B59260AC30EBA5C3495DFAF8DD1618E0BA593FD26B005D0B95B2C6FE0D0CAFD4D4257C04AE76920034F4CA5A1D45A1A06DDA7218F6E8A59440CF671542F7090C2D7CEAB5728EDA9AB1A5270CF390B981967502C490770079DE3074A2AC067F1AD63F9DD1CD47FB070710981";
		try {
			System.out.println("URL: " + url);
			Document doc = Jsoup.connect(url)
			.cookie("ASP.NET_SessionId","yw3b3svzp0mt2155l3i31yud")
			.cookie(".ASPXFORMSPUBLICACCESS",pubacccookie)
			.get();
			
			html = doc.html();			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return html;
	}
	public String getDefendantName(String html){
		Document doc = Jsoup.parse(html);
	
		
		if(doc.getElementById("PIr11") != null){
			return doc.getElementById("PIr11").text();
		}
		else{
			return "PIr11 ID not found";
		}
	}
	public String getCaseNumberHTML(String casenumber){
		//Attempt to beat the captcha on a case search. Didn't work.
		String html = "Error";
		String url = "http://pa.courts.state.mn.us/Search.aspx?ID=100";
		try {
			System.out.println("URL: " + url);
			Document doc = Jsoup.connect(url)
			.data("LBD_VCT_search_samplecaptcha","768da23e945741aebf93c4f22fb32372")
			.data("__VIEWSTATE","/wEPDwULLTEwOTk1NTcyNzAPZBYCZg9kFgICAQ9kFgICAw8PZBYCHgdvbmtleXVwBSZ0aGlzLnZhbHVlID0gdGhpcy52YWx1ZS50b0xvd2VyQ2FzZSgpO2Rk2Eg11k1aGp41RYe6kxVTa121PQQ=")
			.data("__VIEWSTATEGENERATOR","BBBC20B8")
			.data("__EVENTVALIDATION","/wEWAwKj1d/SCwKnkebFBgKYxoa5CI1YYji1oj9Lx4L5p38b63C9Qtpq")
			.data("NodeID","174,151,160,131,132,146,111,175,161,191,176,147,133,119,134,120,121,113,162,1303,1301,1305,1302,1306,122,178,192,179,135,193,163,180,164,148,114,136,137,183,184,138,115,165,154,155,123,139,140,141,185,124,186,194,142,187,166,188,143,167,125,144,189,116,195,117,157,126,168,1491,1492,1493,169,158,170,127,159,128,145,171,129,197,172,190,181,182,153,156,177,173,150,152,11810,11811,11812,11813,11815,11822,11823,11817,11818,11819,11820,1304,13041,13042,13043,13044,1961,1962,1308,11201,11202,13045,11203")
			.data("NodeDesc","All MNCIS Sites - Case Search")
			.data("CodeTextBox","ka4s8")
			.data("CaseSearchMode","CaseNumber")
			.data("CaseSearchValue","02-VB-15-18002")
			.data("SearchType","CASE")
			.data("SearchMode","CASENUMBER")
			.data("SearchParams","SearchBy~~Search By:~~Case~~Case||chkExactName~~Exact Name:~~on~~on||CaseNumberOption~~Case Search Mode:~~CaseNumber~~Number||CaseSearchValue~~Case Number:~~02-VB-15-18002~~02-VB-15-18002||AllOption~~All~~0~~All||selectSortBy~~Sort By:~~Filed Date~~Filed Date")
			.post();
			
			html = doc.html();			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return html;
	}
}
