package primary;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {
	
	public String getHTML(String casenumber){
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
			//e.printStackTrace();
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
}
