package cn.enqiao.util;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Application Lifecycle Listener implementation class testtimer
 *
 */
//@WebListener
public class testtimer implements ServletContextListener {
	private Timer timer = null;

	/**
	 * Default constructor.
	 */
	public testtimer() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(true);
		// 设置任务计划，启动和间隔时间
		timer.schedule(new MyTask(), 0, 1000 * 60 * 60 * 2);

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
