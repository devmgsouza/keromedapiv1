package br.com.projetoa;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;







public class PostMethod {
	private String token_id;
	private int value;
	
	public PostMethod(String token_id, int value) {
		this.token_id = token_id;
		this.value = value;
	}
	
	public void sendRequest(){

		String json =  sendMessageFCM(token_id, value);
		System.out.println(json);
		try {
		
			URL u = new URL("https://fcm.googleapis.com/v1/projects/projetoa-c210f/messages:send");
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty( "Content-Type", "application/json; UTF-8");
			String auth = "Bearer " + getAccessToken();
			System.out.println(auth);
			conn.setRequestProperty( "Authorization", auth);
			conn.connect();
			
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.write(json.getBytes());
			
		   InputStream in = new BufferedInputStream(conn.getInputStream());
           System.out.println(getStringFromInputStream(in));
		   dos.close();
           
            conn.disconnect();
            
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		
	}
	
	private String sendMessageFCM(String token_id, int value){
		JSONObject data = new JSONObject();
		JSONObject message = new JSONObject();
		JSONObject array = new JSONObject();
		
		String content = "";
		
		if (value == 0) {
			content = "Voce recebeu uma solicitacao";
		} else if (value == 1) {
			content = "Medicamento disponibilizado";	
		} else if (value == 2){
			content = "Doacao concluida";	
		} else if ( value == 3) {
			content = "Doacao de medicamento cancelada";
		} 
		try {
			array.put("body", content);
			array.put("title", "Novidades");
			message.put("token", token_id);
			message.put("notification", array);
			data.put("message", message);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return String.valueOf(data);
	}
		
	public  String getAccessToken() throws IOException {
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("firebase_key.json");
		
		  GoogleCredential googleCredential = GoogleCredential
		      .fromStream(is)
		      .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase.messaging"));
		  googleCredential.refreshToken();
		  return googleCredential.getAccessToken();
		}
	
	private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}
