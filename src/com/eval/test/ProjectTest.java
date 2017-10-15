package com.eval.test;

import com.eval.utils.JedisDataClient;
import org.apache.log4j.Logger;

public class ProjectTest {

	private static Logger log = Logger.getLogger(ProjectTest.class);

	public static void main(String[] args) {
		ProjectTest t = new ProjectTest();
		t.test();
		t.init();
		t.clearRedis();
	}

	public void init(){
		insertIntoRedis(100);
	}

	public void test() {
		System.out.println("hello git");
		System.out.println("this is my first project test git and idea");

		try {
			log.info(JedisDataClient.get("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearRedis() {
		try {
			JedisDataClient.delRediss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertIntoRedis(int num) {
		for (int i = 0; i < num; ++i) {
			try {
				JedisDataClient.set("val"+i, i+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
