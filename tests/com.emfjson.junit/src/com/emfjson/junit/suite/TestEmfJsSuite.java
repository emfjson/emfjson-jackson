package com.emfjson.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.emfjson.junit.tests.TestJsLoader;
import com.emfjson.junit.tests.TestJsURIHandler;

@RunWith(Suite.class)
@SuiteClasses({TestJsLoader.class, TestJsURIHandler.class})
public class TestEmfJsSuite {}
