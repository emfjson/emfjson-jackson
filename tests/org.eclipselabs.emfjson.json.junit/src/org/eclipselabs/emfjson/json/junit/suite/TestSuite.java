package org.eclipselabs.emfjson.json.junit.suite;

import org.eclipselabs.emfjson.json.junit.tests.LoadTest;
import org.eclipselabs.emfjson.json.junit.tests.SaveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LoadTest.class, SaveTest.class})
public class TestSuite {}
