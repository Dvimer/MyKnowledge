package chapter8;

import java.sql.ResultSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadLockBad {
    private static ExecutorService exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        RenderPageTask task = new RenderPageTask();
        String call = task.call();
        System.out.println(call);
    }

    public static class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future header = exec.submit(new LoadFileTask("header.html"));
            Future footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            return "";
        }
    }
}
