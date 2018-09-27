package com.chaofan.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CommandTest.class, DirectionTest.class, FileHandlerTest.class,
        FileInputTest.class, MainTest.class, MethodHandlerTest.class, RegexHandlerTest.class,
        RobotTest.class, TableTest.class})
public class SuiteTest {

}
