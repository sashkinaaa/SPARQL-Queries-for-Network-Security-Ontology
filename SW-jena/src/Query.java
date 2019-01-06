import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;


public class Query {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel();
		model = FileManager.get().loadModel("C:\\Users\\v_hri\\Desktop\\TU\\SW\\FinalData.rdf");
		String qStr = 	"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " + 
						"PREFIX owl: <http://www.w3.org/2002/07/owl#> " + 
						"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " + 
						"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " + 
						"PREFIX sec: <http://www.semanticweb.org/NetworkSecurity#> " + 
					//1.
					//	"SELECT * WHERE {?nss rdf:type sec:Network_Security_System . }";
					//2.
					//"SELECT ?group ?individual WHERE {?group  rdfs:subClassOf sec:Inspection . ?group ^rdf:type ?individual }";
					//3.
					//	"SELECT ?nss WHERE {?nss sec:hasInspection ?emailfilter . ?emailfilter rdf:type sec:E-mail_Filter . }";
					//5.
					//	"SELECT ?nss WHERE {?nss sec:hasLogin_System sec:Fingerprint_Recognition}";
					//11.
					//"SELECT ?nss ?p	WHERE {?nss sec:hasPrice ?p } ORDER BY DESC (?p) LIMIT 2";
					//12.
					//"SELECT * WHERE {?nss sec:hasPrice ?p FILTER(?p < 500)} ";
					//13.
					"SELECT ?nss WHERE {?nss sec:hasOwner ?ow FILTER(?ow = \"BillGates\")}";
					
		org.apache.jena.query.Query q = QueryFactory.create(qStr);
		QueryExecution qe = QueryExecutionFactory.create(q,model);
		try {
			ResultSet rs = qe.execSelect();
			while(rs.hasNext()) {
				QuerySolution sln = rs.nextSolution();
				Resource name = sln.getResource("nss");
				System.out.println(name);
				//za 2
				//Resource name2 = sln.getResource("individual");
				//za 11
				//Literal name2 = sln.getLiteral("p");
				//za 2,11
				//System.out.println(name + " " + name2);
				
			}
		} finally {
			qe.close();
		}
	}

}
