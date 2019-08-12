package org.ifmo.technologies;

import org.eclipse.jetty.server.Server;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Этот обработчик запросов общего назначения на самом деле распознает только
 * запросы типа GET и просто передает содержимое запрашиваемого файла,
 * если, конечно, такой файл (страница) существует.
 */
public class FileHandler {


	public static void main(String[] args) {
        Server server = new Server(8080);
		Properties props = new Properties();
		try {
			props.load(new FileReader("e:/teaching/sergey/project/server/jetty01/param.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		server.setHandler(new MyHandler(props.getProperty("root")));
        try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
