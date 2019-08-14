package org.ifmo.technologies;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * Этот обработчик запросов общего назначения на самом деле распознает только
 * запросы типа GET и просто передает содержимое запрашиваемого файла,
 * если, конечно, такой файл (страница) существует.
 */
public class FileHandler {
    final static String propsName = "server/jetty01/param.properties";

	public static void main(String[] args) {
        Server server = new Server(8080);
		Properties props = new Properties();
		String handlerName;
		String root;
		try {
			props.load(new FileReader(propsName));
			handlerName = props.getProperty("handler");
			root = props.getProperty("root");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
        try {
            Class<Handler> handlerClass = (Class<Handler>)Class.forName(handlerName);
            Constructor<Handler> handlerConstructor = handlerClass.getConstructor(String.class);
            Handler handler = handlerConstructor.newInstance(root);
            server.setHandler(handler);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
