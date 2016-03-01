package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class TrainerCatalogApp {

	public static void main(String[] args) {
		Catalog catalog = new Catalog("Java");
		initTrainee(catalog);
	
		TrainerCatalogInterface trainer = catalog;
		work(trainer);

		SiteManagerInterface siteManager = catalog;
		work(siteManager);

	}
	private static void initTrainee(Catalog cat){
		cat.addTrainees("mircea", "dmircead@gmail.com", "");
		cat.addTrainees("adina", "adinadeznan@gmail.com", "");

	}

	private static void work(TrainerCatalogInterface trainer) {
		trainer.addGrade("mircea", 8);
		trainer.addGrade("adina", 10);
		trainer.addGrade("mircea", 4);
		trainer.addGrade("adina", 9);
		
	}
	/**
	 * the site manager works with the catalog
	 * @param siteManager
	 */
	private static void work(SiteManagerInterface siteManager) {
		siteManager.printGrades("mircea");
		siteManager.printCatalog();
	}
}
