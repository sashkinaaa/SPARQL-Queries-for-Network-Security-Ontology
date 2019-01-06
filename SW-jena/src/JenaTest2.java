import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class JenaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel();
		model = FileManager.get().loadModel("C:\\Users\\v_hri\\Desktop\\TU\\SW\\random FIles\\data.rdf");
		model.write(System.out,"JSON-LD");
	}

}

