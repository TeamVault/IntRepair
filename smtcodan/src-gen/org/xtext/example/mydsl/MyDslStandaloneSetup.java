/*
* generated by Xtext
*/
package org.xtext.example.mydsl;

// TODO: Auto-generated Javadoc
/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry.
 */
public class MyDslStandaloneSetup extends MyDslStandaloneSetupGenerated{

	/**
	 * Do setup.
	 */
	public static void doSetup() {
		new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

