package com.eval.test;

import com.eval.utils.JedisDataClient;
import org.apache.log4j.Logger;

import java.util.Date;

public class ProjectTest {

	private static Logger log = Logger.getLogger(ProjectTest.class);

	private static int MAX_NUM = 100;

	public static void main(String[] args) {
		ProjectTest t = new ProjectTest();
		t.test();
		t.init();
		t.clearRedis();
	}

	public void init(){
		Date d1 = new Date();
		insertIntoRedis(MAX_NUM);
		Date d2 = new Date();
		log.info("insert time : " + (d2.getTime()-d1.getTime()) + "ms");
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
