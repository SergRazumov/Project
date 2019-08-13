package org.ifmo.technologies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;


/**
 * Этот обработчик запросов общего назначения на самом деле распознает только
 * запросы типа GET и просто передает содержимое запрашиваемого файла,
 * если, конечно, такой файл (страница) существует.
 */
public class FileHandler {


	public static void main(String[] args) {
        Server server = new Server(8080);
		System.out.println(System.getProperty("user.dir"));
        server.setHandler(new MyHandler());
        try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
