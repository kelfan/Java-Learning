package com.chaofan;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * This is the class to handle reflection of methods
 */
public class MethodHandler {
    /**
     * method to invoke a method with parameters by strings
     * @param obj the object will run the method
     * @param methodName the name of method, which will be invoked
     * @param param the parameters will be passed to the method
     * @throws NoSuchMethodException error if the method is not in the object
     * @throws InvocationTargetException error if cannot use the method
     * @throws IllegalAccessException error if cannot access the object or method
     */
    public static void callFunction(Object obj, String methodName, String param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod(methodName, String.class);
        if (Modifier.isPublic(method.getModifiers())) {
            method.invoke(obj, param);
        }
    }

    /**
     * method to invoke a method by strings
     * @param obj the object will run the method
     * @param methodName the name of method, which will be invoked
     * @throws InvocationTargetException error if cannot access the object or method
     * @throws IllegalAccessException error if cannot use the method
     * @throws NoSuchMethodException error if the method is not in the object
     */
    public static void callFunction(Object obj, String methodName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = obj.getClass().getMethod(methodName);
        if (Modifier.isPublic(method.getModifiers())) {
            method.invoke(obj);
        }
    }
}
