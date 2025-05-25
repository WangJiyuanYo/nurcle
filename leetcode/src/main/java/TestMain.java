import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class TestMain {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\r\n    \"model\": \"deepseek-chat\",\r\n    \"messages\": [\r\n        {\r\n            \"role\": \"system\",\r\n            \"content\": \"You are a helpful assistant.\"\r\n        },\r\n        {\r\n            \"role\": \"user\",\r\n            \"content\": \"北京时间!\"\r\n        }\r\n    ],\r\n    \"stream\": false\r\n}");
        Request request = new Request.Builder()
                .url("https://api.deepseek.com/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer ")
                .addHeader("Cookie", "HWWAFSESID=71f5a7feebf5276362; HWWAFSESTIME=1748146110669")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            JSONObject jsonObject = JSON.parseObject(res);
            JSONArray choices = (JSONArray) jsonObject.get("choices");
            JSONObject message = (JSONObject) choices.get(0);
            JSONObject m1 = (JSONObject) message.get("message");
            String replay = (String) m1.get("content");
            System.out.println(replay);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
