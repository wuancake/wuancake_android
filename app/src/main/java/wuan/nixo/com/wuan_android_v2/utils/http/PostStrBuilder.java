package wuan.nixo.com.wuan_android_v2.utils.http;


import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.request.PostFormRequest;
import com.zhy.http.okhttp.request.RequestCall;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanghongyu on 2018/6/20.
 */

public class PostStrBuilder extends PostFormBuilder {
    private List<PostFormBuilder.FileInput> files = new ArrayList<>();

    @Override
    public RequestCall build() {
        return new PostFormRequest(url, tag, params, headers, files, id).build();
    }

    public PostFormBuilder files(String key, Map<String, File> files) {
        for (String filename : files.keySet()) {
            this.files.add(new PostFormBuilder.FileInput(key, filename, files.get(filename)));
        }
        return this;
    }

    public PostFormBuilder url(String url) {
        this.url = url;
        PostFormBuilder postJsonBuilder = addHeader();
        return postJsonBuilder;
    }

    public PostFormBuilder addFile(String name, String filename, File file) {
        files.add(new PostFormBuilder.FileInput(name, filename, file));
        return this;
    }

    public static class FileInput {
        public String key;
        public String filename;
        public File file;

        public FileInput(String name, String filename, File file) {
            this.key = name;
            this.filename = filename;
            this.file = file;
        }

        @Override
        public String toString() {
            return "FileInput{" +
                    "key='" + key + '\'' +
                    ", filename='" + filename + '\'' +
                    ", file=" + file +
                    '}';
        }
    }

    private PostFormBuilder addHeader() {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }




        return this;
    }

    @Override
    public PostFormBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public PostFormBuilder addParams(String key, String val) {
        if (this.params == null) {
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }

}
