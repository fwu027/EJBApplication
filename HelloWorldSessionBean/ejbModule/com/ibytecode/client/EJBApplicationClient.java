package com.ibytecode.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ibytecode.business.HelloWorld;
import com.ibytecode.businesslogic.HelloWorldBean;
import com.ibytecode.clientutility.ClientUtility;

public class EJBApplicationClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorld bean = doLookup();
		System.out.println(bean.sayHello());
	}
	
	private static HelloWorld doLookup() {
		Context context = null;
		HelloWorld bean = null;
		try {
			context = ClientUtility.getInitialContext();
			System.out.println(context);
			String lookupName = getLookupName();
			bean = (HelloWorld) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	private static String getLookupName() {
		String appName = "";
		String moduleName = "HelloWorldSessionBean";
		String distinctName = "";
		String beanName = HelloWorldBean.class.getSimpleName();
		final String interfaceName = HelloWorld.class.getName();
		
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		System.out.println(name);
		return name;
	}
}
