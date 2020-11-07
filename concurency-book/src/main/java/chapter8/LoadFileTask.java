package chapter8;

import java.util.concurrent.Callable;

public class LoadFileTask implements Callable<String> {
    private String htmlPage;

    public LoadFileTask(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String getHtmlPage() {
        return htmlPage;
    }

    @Override
    public String call() throws Exception {
        return htmlPage.split("\\.")[0];
    }
}
