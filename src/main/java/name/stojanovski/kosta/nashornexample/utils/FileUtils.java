package name.stojanovski.kosta.nashornexample.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import name.stojanovski.kosta.nashornexample.IConstants;

public class FileUtils implements IConstants {

	public static String getFileAsString(String filename) {
		String fileContent = EMPTY_STRING;
		try {
			fileContent = new String(Files.readAllBytes(extractedPath(filename)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public static Reader getFileAsReader(String filename) {
		Reader fileReader = null;
		try {
			fileReader = Files.newBufferedReader(extractedPath(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileReader;
	}

	public static ByteArrayInputStream getFileAsByteInputStream(String filename) {
		ByteArrayInputStream byteArrayInputStream = null;
		try {
			byteArrayInputStream = new ByteArrayInputStream(Files.readAllBytes(extractedPath(filename)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArrayInputStream;
	}

	public static URL getFileAsUrl(String filename) {
		URL url = null;
		try {
			url = extractedPath(filename).toUri().toURL();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	public static Path extractedPath(String filename) {
		String pathTo = EMPTY_STRING;
		if (filename.endsWith(JS_FILE_SUFFIX)) {
			pathTo = SRC_MAIN_JAVASCRIPT;
		} else if (filename.endsWith(XML_FILE_SUFFIX)) {
			pathTo = SRC_MAIN_RESOURCES;
		} else {
			pathTo = SRC_MAIN_RESOURCES;
		}
		return FileSystems.getDefault().getPath(pathTo, filename);
	}
}
