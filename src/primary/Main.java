package primary;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//424352988
		String casenumber = "02-VB-15-18002";
		for(int i=0;i<1;i++){
			Scraper MinnScraper = new Scraper();
			String html = MinnScraper.getHTML(casenumber);
			String defname = MinnScraper.getDefendantName(html);
			System.out.println("Case Number: " + casenumber + " Def Name: " + defname + " #" + i);
			int temp = Integer.parseInt(casenumber);
			temp++;
			casenumber = Integer.toString(temp);
			
			
		}
	}

}
