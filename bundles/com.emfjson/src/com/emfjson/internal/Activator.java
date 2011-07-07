package com.emfjson.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author guillaume
 *
 */
public class Activator implements BundleActivator {

	private static Activator instance;

	public static Activator getInstance() {
		return instance;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;		
	}

}
