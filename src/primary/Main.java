package primary;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//424352988
		String casenumber = "1619194469";
		for(int i=0;i<100;i++){
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
