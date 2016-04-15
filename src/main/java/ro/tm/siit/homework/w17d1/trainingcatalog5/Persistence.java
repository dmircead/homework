/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;

/**
 * @author mco
 *
 */
public class Persistence {
	private Path file = Paths.get("catalog.data");	

	public void saveCatalog(Catalog catalog) {
		try (OutputStream os = Files.newOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(catalog);
		} catch (IOException e) {
			System.out.println("problem saving catalog data " + e.getMessage());
		}
	}

	public Catalog loadCatalog() {
		Catalog catalog;
		if (Files.exists(file)) {
			try (InputStream is = Files.newInputStream(file); 
					ObjectInputStream ois = new ObjectInputStream(is)) {
				Catalog cat = (Catalog) ois.readObject();
				System.out.println(cat);
				return cat;
				
			} catch (IOException e) {
				System.out.println("problem loading catalog data " + e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("problem loading catalog data " + e.getMessage());
			}
		}
		return  catalog = null;
		
	}
	
	public Catalog createCatalog(String name, Messenger messenger){
		Catalog catalog = new Catalog(name, messenger);
		return catalog;
	}
}
