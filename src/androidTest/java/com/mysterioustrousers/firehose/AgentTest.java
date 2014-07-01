package com.mysterioustrousers.firehose;

import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AgentTest extends AndroidTestCase {

    private Agent mAgent;
    private RequestQueue mRequestQueue;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }



    @SmallTest
    public void testMultiply() {

        assertEquals("10 x 5 must be 50", 50, 10*5);
    }
    /**
     * This demonstrates how to test AsyncTasks in android JUnit. Below I used
     * an in line implementation of a asyncTask, but in real life you would want
     * to replace that with some task in your application.
     * @throws Throwable
     */
    public void testSomeAsynTask () throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);
        mRequestQueue = Volley.newRequestQueue(getContext());

    /* Just create an in line implementation of an asynctask. Note this
     * would normally not be done, and is just here for completeness.
     * You would just use the task you want to unit test in your project.
     */
        final AsyncTask<String, Void, String> myTask = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... arg0) {
                //Do something meaningful.
                GsonRequest<Agent> loginRequest = Agent.login("@", "jjjjj", new Response.Listener<Agent>() {
                    @Override
                    public void onResponse(Agent response) {
                        mAgent = response;
                        signal.countDown();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                mRequestQueue.add(loginRequest);
                return "something happened!";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

            /* This is the key, normally you would use some type of listener
             * to notify your activity that the async call was finished.
             *
             * In your test method you would subscribe to that and signal
             * from there instead.
             */
                Log.e("Firehose", result);
                //signal.countDown();
            }
        };

        myTask.execute("Do something");


    /* The testing thread will wait here until the UI thread releases it
     * above with the countDown() or 30 seconds passes and it times out.
     */
        signal.await(30, TimeUnit.SECONDS);

        // The task is done, and now you can assert some things!
        assertTrue("Happiness", true);
    }

}
