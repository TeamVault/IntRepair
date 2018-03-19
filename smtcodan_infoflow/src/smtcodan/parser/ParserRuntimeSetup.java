package smtcodan.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;

import smtcodan.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleGeneratorSetup.
 */
public class ParserRuntimeSetup implements ISetup {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ISetup#createInjectorAndDoEMFRegistration()
	 */
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		new org.eclipse.xtext.common.TerminalsRuntimeModule();
		System.out.println("Parser Run-time Setup Started ...");
		Injector injector = createInjector(Activator.mergedModule);
		register(injector);
		return injector;
	}

	/**
	 * Creates the injector.
	 * 
	 * @param module
	 *            the module
	 * @return the injector
	 */
	public Injector createInjector(Module module) {
		return Guice.createInjector(module);
	}

	/**
	 * Register.
	 * 
	 * @param injector
	 *            the injector
	 */
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE
				.containsKey("http://www.xtext.org/example/mydsl/MyDsl")) {
			EPackage.Registry.INSTANCE.put(
					"http://www.xtext.org/example/mydsl/MyDsl",
					org.xtext.example.mydsl.myDsl.MyDslPackage.eINSTANCE);
		}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector
				.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector
				.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("h",
				resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE
				.getExtensionToFactoryMap().put("h", serviceProvider);
	}
}
