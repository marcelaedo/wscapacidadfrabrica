
package cl.akzio.auth.central.obtenercapacidadfabrica.log4j;
import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.xml.DOMConfigurator;

public class ConfigLog4jListener implements ServletContextListener ,Serializable{
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 16434547207071793L;
	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		/* No hace nada */
	}
	/**
	 * Inicializa variables de contexto.
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		String log4jFile = servletContext.getInitParameter("log4jPath");
		DOMConfigurator.configure(log4jFile);
	}
}