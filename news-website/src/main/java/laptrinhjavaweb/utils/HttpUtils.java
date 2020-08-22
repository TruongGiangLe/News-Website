package laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	
	private String value;
	
	public HttpUtils(String value) {
		this.value = value;
	}
	
	// map string (đc chuyển từ json qua) với model
	public <T> T toModel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(value, tclass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static HttpUtils of (BufferedReader reader) {
		StringBuilder json = new StringBuilder();
		try {
			String line = reader.readLine();
			while(line != null) {
				json.append(line);
				line = reader.readLine();
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}

		return new HttpUtils(json.toString());
	}
}
