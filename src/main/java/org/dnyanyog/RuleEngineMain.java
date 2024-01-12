package org.dnyanyog;

import org.dnyanyog.config.DroolsBeanFactory;
import org.dnyanyog.dto.Customer;
import org.kie.api.runtime.KieSession;

public class RuleEngineMain {

	public static void main(String[] args) {

		KieSession kSession = new DroolsBeanFactory().getKieSession();

		if (kSession != null) {
			// Now you can use kSession to insert objects and fire rules
			// For example, insert a Customer object
			Customer customer = new Customer();
			customer.setAge(20);
			customer.setGender("M");
			kSession.insert(customer);

			// Fire the rules
			kSession.fireAllRules();

			// Close the session
			kSession.dispose();

			// Print the result
			System.out.println("Updated customer: " + customer);
		} else {
			System.err.println("Failed to create KieSession.");
		}
	}
}
