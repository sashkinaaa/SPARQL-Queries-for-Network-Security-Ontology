import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;

public class JenaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel();
		String NS = "http://sasho.com/test#";
		Resource r = model.createResource(NS + "me");
		Property p = model.createProperty(NS + "say");
		Literal l = model.createLiteral("Hello");
		Statement st = model.createStatement(r, p, l);
		model.add(st);
		model.write(System.out,"Turtle");
	}

}
