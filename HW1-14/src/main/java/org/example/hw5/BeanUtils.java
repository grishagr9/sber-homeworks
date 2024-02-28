package org.example.hw5;

import java.beans.*;
import java.lang.reflect.*;

public class BeanUtils {
    public static void assign(Object to, Object from) {
        try {
            // Полный список методов класса "from"
            Method[] fromMethods = from.getClass().getMethods();

            for (Method fromMethod : fromMethods) {
                // Если метод - getter (начинается с "get" или "is")
                if (isGetter(fromMethod)) {
                    // Имя свойства, получаемое из имени метода getter
                    String propertyName = getPropertyName(fromMethod);

                    // Получаем тип возвращаемого значения
                    Class<?> returnType = fromMethod.getReturnType();

                    // Получаем соответствующий метод setter в классе "to"
                    Method toMethod = findSetter(to.getClass(), propertyName, returnType);

                    // Если метод с таким именем и типом найден, вызываем его
                    if (toMethod != null) {
                        toMethod.invoke(to, fromMethod.invoke(from));
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // Метод для определения является ли метод getter'ом
    private static boolean isGetter(Method method) {
        String methodName = method.getName();
        return (methodName.startsWith("get") && methodName.length() > 3) ||
                (methodName.startsWith("is") && methodName.length() > 2);
    }

    // Метод для получения имени свойства из имени метода getter'а
    private static String getPropertyName(Method method) {
        String methodName = method.getName();
        if (methodName.startsWith("get")) {
            return methodName.substring(3);
        } else if (methodName.startsWith("is")) {
            return methodName.substring(2);
        }
        return null;
    }

    // Метод для поиска метода setter с заданным именем и типом параметра в классе
    private static Method findSetter(Class<?> clazz, String propertyName, Class<?> propertyType) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(propertyType) && method.getName().substring(3).equals(propertyName)) {
                    return method;
                }
            }
        }
        return null;
    }
}