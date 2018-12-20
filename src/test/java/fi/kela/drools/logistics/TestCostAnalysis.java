package fi.kela.drools.logistics;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.kela.drools.logistics.data.City;
import fi.kela.drools.logistics.data.OrderLine;
import fi.kela.drools.logistics.data.Product;
import fi.kela.drools.logistics.data.Transportation;
import fi.kela.drools.logistics.data.TransportationCosts;
import fi.kela.drools.logistics.data.Trip;
import fi.kela.drools.logistics.data.TripStep;
import fi.kela.drools.util.KnowledgeSessionHelper;

public class TestCostAnalysis {
	
    static Logger logger = LoggerFactory.getLogger(TestCostAnalysis.class.getName());
    static KieContainer kieContainer = null;
	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	
    @BeforeClass
    public static void beforeClass(){
        kieContainer=KnowledgeSessionHelper.createRuleBase();
    }

    @Before
    public void setUp() throws Exception{
        logger.debug("------------Before------------");
    }
    
    @After
    public void tearDown() throws Exception{
    	logger.debug("------------After------------");
    }

    @Test
	public void testCalculateCosts() {
		sessionStateful = KnowledgeSessionHelper
	             .getStatefulKnowledgeSessionForJBPM(kieContainer,"ksession-rules");

		// We list the facts in the exercise and put them in the session
		Product p1 = new Product(1, "Drill", 20, 40, 30, Product.TYPE_PALLET, 2);
		Product p2 = new Product(2, "Screwdriver", 3, 2, 20, Product.TYPE_PALLET, 0.2);
		Product p3 = new Product(3, "Sand", 0, 0, 0, Product.TYPE_BULK, 0);
		Product p4 = new Product(4, "Gravel", 0, 0, 0, Product.TYPE_BULK, 0);
		Product p5 = new Product(5, "Furniture", 0, 0, 0, Product.TYPE_INDIVIDUAL, (500.0/23));
		sessionStateful.insert(p1);
		sessionStateful.insert(p2);
		sessionStateful.insert(p3);
		sessionStateful.insert(p4);
		sessionStateful.insert(p5);

		OrderLine ol1 = new OrderLine(p1, 1000);
		OrderLine ol2 = new OrderLine(p2, 30000);
		OrderLine ol3 = new OrderLine(p3, 35000);
		OrderLine ol4 = new OrderLine(p4, 14000);
		OrderLine ol5 = new OrderLine(p5, 23);
		sessionStateful.insert(ol1);
		sessionStateful.insert(ol2);
		sessionStateful.insert(ol3);
		sessionStateful.insert(ol4);
		sessionStateful.insert(ol5);
		
		City c1 = new City("Shanghai", 0.02, 0, 20, 13);
		City c2 = new City("Rotterdam", 0.05, 1, 45, 60);
		City c3 = new City("Tournai", 0, 2, 67, 40);
		City c4 = new City("Lille", 0, 30, 79, 30);
		sessionStateful.insert(c1);
		sessionStateful.insert(c2);
		sessionStateful.insert(c3);
		sessionStateful.insert(c4);
		
		Transportation t1 = new Transportation("Boat", 0.2);
		Transportation t2 = new Transportation("Train", 0.5);
		Transportation t3 = new Transportation("Truck", 1);
		sessionStateful.insert(t1);
		sessionStateful.insert(t2);
		sessionStateful.insert(t3);
		
		TripStep ts1 = new TripStep(c1, c2, 22000, t1);
		TripStep ts2 = new TripStep(c2, c3, 300, t2);
		TripStep ts3 = new TripStep(c3, c4, 20, t3);
		List<TripStep> tripSteps = new ArrayList<TripStep>();
		tripSteps.add(ts1);
		tripSteps.add(ts2);
		tripSteps.add(ts3);
		Trip trip = new Trip(tripSteps);
		sessionStateful.insert(trip);
		
		// We'll start with zero cost - this is the "results class"
		TransportationCosts costs = new TransportationCosts();
		costs.setHandlingCostsEuro(0);
		costs.setNumberOfPallets(0);
		costs.setTaxesEuro(0);
		costs.setTransportCostsEuro(0);
		sessionStateful.insert(costs);
		
        sessionStateful.startProcess("ruleprocess1");
		sessionStateful.fireAllRules();
		
		logger.info("Number of pallets: " + costs.getNumberOfPallets());
		logger.info("Transportation costs: " + costs.getTransportCostsEuro());
		logger.info("Taxes: " + costs.getTaxesEuro());
		logger.info("Handling costs: " + costs.getHandlingCostsEuro());
		logger.info("TOTAL COST: " + (costs.getTransportCostsEuro()+costs.getTaxesEuro()+costs.getHandlingCostsEuro()));
		
		sessionStateful.dispose();
	}


}
