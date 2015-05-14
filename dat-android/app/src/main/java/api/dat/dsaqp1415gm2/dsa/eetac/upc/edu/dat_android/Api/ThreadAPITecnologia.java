package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

/**
 * Created by Manel on 09/04/2015.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class ThreadAPITecnologia {
    private final static String TAG = ThreadAPITecnologia.class.getName();
    private static ThreadAPITecnologia instance = null;
    private URL url;

    private ThreadRootAPI rootAPI = null;

    private ThreadAPITecnologia(Context context) throws IOException, AppException {
        super();

        AssetManager assetManager = context.getAssets();
        Properties config = new Properties();
        config.load(assetManager.open("config.properties"));
        String urlHome = config.getProperty("dat.home.tecnologia");
        url = new URL(urlHome);

        Log.d("LINKS", url.toString());
        //getRootAPI();
        getThreads();
    }

    public final static ThreadAPITecnologia getInstance(Context context) throws AppException {
        if (instance == null)
            try {
                instance = new ThreadAPITecnologia(context);
            } catch (IOException e) {
                throw new AppException(
                        "Can't load configuration file");
            }
        return instance;
    }

    private void getRootAPI() throws AppException {
        Log.d(TAG, "getRootAPI()");
        rootAPI = new ThreadRootAPI();
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.connect();
        } catch (IOException e) {
            throw new AppException(
                    "Can't connect to API Web Service");
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonLinks = jsonObject.getJSONArray("links");
            parseLinks(jsonLinks, rootAPI.getLinks());
        } catch (IOException e) {
            throw new AppException(
                    "Can't get response from API Web Service");
        } catch (JSONException e) {
            throw new AppException("Error parsing Beeter Root API");
        }
    }

    public Theme getThreads() throws AppException {
        Log.d(TAG, "getThreads()");
        Theme threads = new Theme();

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.connect();
        } catch (IOException e) {
            throw new AppException(
                    "Can't connect to API Web Service");
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonThreads = jsonObject.getJSONArray("threads");

            for (int i = 0; i < jsonThreads.length(); i++) {
                Threadx thread = new Threadx();
                JSONObject jsonThread = jsonThreads.getJSONObject(i);
                thread.setContent(jsonThread.getString("content"));
                thread.setSubject(jsonThread.getString("subject"));
                thread.setIdtema(jsonThread.getInt("idtema"));
                thread.setIdthread(jsonThread.getInt("idthread"));
                thread.setImagen(jsonThread.getString("imagen"));
                threads.getThreads().add(thread);
            }
        } catch (IOException e) {
            throw new AppException(
                    "Can't get response from API Web Service");
        } catch (JSONException e) {
            throw new AppException("Error parsing Root API");
        }
        return threads;
    }

    private void parseLinks(JSONArray jsonLinks, Map<String, Link> map)
            throws AppException, JSONException {
        for (int i = 0; i < jsonLinks.length(); i++) {
            Link link = null;
            try {
                link = SimpleLinkHeaderParser
                        .parseLink(jsonLinks.getString(i));
            } catch (Exception e) {
                throw new AppException(e.getMessage());
            }
            String rel = link.getParameters().get("rel");
            String rels[] = rel.split("\\s");
            for (String s : rels)
                map.put(s, link);
        }
    }

}