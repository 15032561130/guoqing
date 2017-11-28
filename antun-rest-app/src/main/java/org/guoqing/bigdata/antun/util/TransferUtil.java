package org.guoqing.bigdata.antun.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class TransferUtil {

	public static void transfer(Object dest, Object orig) {

		try {

			PropertyUtils.copyProperties(dest, orig);

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		} catch (InvocationTargetException e) {

			e.printStackTrace();

		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		}
	}

	public static void transferThrow(Object dest, Object orig)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

		PropertyUtils.copyProperties(dest, orig);
	}

	public static <T> T transfer(Object object, Class<T> class1) {
		try {
			T newInstance = class1.newInstance();

			transfer(newInstance, object);

			return newInstance;

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
