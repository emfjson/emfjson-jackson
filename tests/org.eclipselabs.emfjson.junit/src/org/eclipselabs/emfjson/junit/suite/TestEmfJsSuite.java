package org.eclipselabs.emfjson.junit.suite;

import org.eclipselabs.emfjson.junit.tests.TestJsLoader;
import org.eclipselabs.emfjson.junit.tests.TestJsURIHandler;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({TestJsLoader.class, TestJsURIHandler.class})
public class TestEmfJsSuite {}
