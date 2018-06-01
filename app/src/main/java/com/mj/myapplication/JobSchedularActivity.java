package com.mj.myapplication;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class JobSchedularActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mStart, mStop;
    private static final String TAG=JobSchedularActivity.class.getSimpleName();
    private int JOB_ID=10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_schedular);
        mStart=(Button)findViewById(R.id.start_job_schedular);
        mStop=(Button)findViewById(R.id.stop_job_schedular);

        mStart.setOnClickListener(this);
        mStop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start_job_schedular)
        {
            ComponentName componentName=new ComponentName(this,JobSchedulerService.class);
            JobInfo jobInfo=new JobInfo.Builder(JOB_ID,componentName)
                    .setRequiresCharging(true)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                    .setPersisted(true)
                    .setPeriodic(15*60*1000)
                    .build();
            JobScheduler jobScheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
            int resultCode=jobScheduler.schedule(jobInfo);
            if(resultCode==JobScheduler.RESULT_SUCCESS)
            {
                Log.d(TAG, "Job Scheduled");
            }
            else
            {
                Log.d(TAG, "Job Schedule Failed");
            }
        }
        else  if(v.getId()==R.id.stop_job_schedular)
        {
            JobScheduler jobScheduler=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
            jobScheduler.cancel(JOB_ID);
            Log.d(TAG, "Job Cancelled");
        }
    }
}
