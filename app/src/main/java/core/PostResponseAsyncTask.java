package core;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * 이 클래스는 AsyncTask클래스를 상속 받아서 비동기 통신(백그라운드 작업) 기능을 구현합니다.
 */
public class PostResponseAsyncTask extends AsyncTask {
    //멤버변수 = 필드변수
    private Context context;
    private HashMap<String, String> postDataParams = new HashMap<String, String>();
    private AsysncResponse asysncResponse;
    private ProgressDialog progressDialog; //스프링으로 요청을 보낸 후 응답을 받을 때까지 화면에 '처리중 입니다.'메세지를 나오게 하는 대화상자
    private String loadingMessage = "처리중 입니다.";
    private boolean showLoadingMessage = true; //위 로딩메세지를 응답을 받을 때 화면에서 지우기 위해서 생성

    public PostResponseAsyncTask(Context context, HashMap<String, String> postDataParams, AsysncResponse asysncResponse) {
        this.context = context;
        this.postDataParams = postDataParams;
        this.asysncResponse = asysncResponse; //비동기 통신을 종료할 때의 결과를 출력
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public HashMap<String, String> getPostDataParams() {
        return postDataParams;
    }

    public void setPostDataParams(HashMap<String, String> postDataParams) {
        this.postDataParams = postDataParams;
    }

    public AsysncResponse getAsysncResponse() {
        return asysncResponse;
    }

    public void setAsysncResponse(AsysncResponse asysncResponse) {
        this.asysncResponse = asysncResponse;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public void setLoadingMessage(String loadingMessage) {
        this.loadingMessage = loadingMessage;
    }

    public boolean isShowLoadingMessage() {
        return showLoadingMessage;
    }

    public void setShowLoadingMessage(boolean showLoadingMessage) {
        this.showLoadingMessage = showLoadingMessage;
    }

    @Override
    protected Object doInBackground(String[] requestUrls) { //LoginActivity에서 readTask.execute(requestUrl); 실행시 실행됨.
        //비동기 통신에서 요청사항을 스프링앱에서 응답받는 기능
        String result ="";
        result = invokePost(requestUrls[0], postDataParams);
        return null;
    }

    private String invokePost(String requestUrl, HashMap<String, String> postDataParams) {
        URL url;
        String response = "";
        try {
            url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
